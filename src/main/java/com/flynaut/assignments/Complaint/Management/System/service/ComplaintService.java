package com.flynaut.assignments.Complaint.Management.System.service;

import com.flynaut.assignments.Complaint.Management.System.Entity.Complaint;
import com.flynaut.assignments.Complaint.Management.System.enums.ComplaintStatus;

import java.util.List;
import java.util.Map;

public interface ComplaintService {

    Complaint raiseComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();
    Complaint getComplaintById(Long id);
    Complaint updateStatus(Long id, ComplaintStatus status);
    Map<String, Long> getStatusCount();

}
