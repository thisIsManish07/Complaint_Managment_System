package com.flynaut.assignments.Complaint.Management.System.service;

import com.flynaut.assignments.Complaint.Management.System.Entity.Complaint;
import com.flynaut.assignments.Complaint.Management.System.enums.ComplaintStatus;
import com.flynaut.assignments.Complaint.Management.System.repo.ComplaintRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService{


    private final ComplaintRepo complaintRepo;

    @Override
    public Complaint raiseComplaint(Complaint complaint) {
        return complaintRepo.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }

    @Override
    public Complaint getComplaintById(Long id) {
        return complaintRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compalint Not found with ID: "+id));
    }

    @Override
    public Complaint updateStatus(Long id, ComplaintStatus status) {
        Complaint complaint = complaintRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        if(isValidStatusTransition(complaint.getStatus(),status)){
            complaint.setStatus(status);
            if (status==ComplaintStatus.RESOLVED){
                complaint.setResolverOn(LocalDateTime.now());
            }
            return complaintRepo.save(complaint);
        }else {
            throw new IllegalArgumentException("Invalid status transition from "+ complaint.getStatus()+"to"+status);
        }
    }

    private boolean isValidStatusTransition(ComplaintStatus current, ComplaintStatus next) {
        return (current == ComplaintStatus.OPEN && next==ComplaintStatus.IN_PROGRESS)
                || (current == ComplaintStatus.IN_PROGRESS && next == ComplaintStatus.RESOLVED);
    }

    @Override
    public Map<String, Long> getStatusCount() {
         return complaintRepo.findAll().stream()
                .collect(Collectors.groupingBy(c->c.getStatus().name(),Collectors.counting()));
    }
}
