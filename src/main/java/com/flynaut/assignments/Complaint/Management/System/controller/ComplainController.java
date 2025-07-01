package com.flynaut.assignments.Complaint.Management.System.controller;

import com.flynaut.assignments.Complaint.Management.System.Entity.Complaint;
import com.flynaut.assignments.Complaint.Management.System.enums.ComplaintStatus;
import com.flynaut.assignments.Complaint.Management.System.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CONTINUE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/complaints")
@RequiredArgsConstructor
public class ComplainController {

    private final ComplaintService complaintService;

    @PostMapping("/raise")
    public ResponseEntity<Complaint> raiseComplaint(@RequestBody Complaint complaint){
        complaint.setRaisedOn(LocalDateTime.now());
        Complaint complaint1 = complaintService.raiseComplaint(complaint);
        return ResponseEntity.status(CREATED).body(complaint1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> getAllComplaints(){
        List<Complaint> allComplaints = complaintService.getAllComplaints();
        return ResponseEntity.ok(allComplaints);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id){
        Complaint complaintById = complaintService.getComplaintById(id);
        return ResponseEntity.ok(complaintById);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Complaint> update(@RequestBody ComplaintStatus complaint, @PathVariable Long id){
        return  ResponseEntity.ok(complaintService.updateStatus(id,complaint));
    }

    @GetMapping("/status-count")
    public ResponseEntity<Map<String, Long>> getStatusCount(){
        return ResponseEntity.ok(complaintService.getStatusCount());
    }

}
