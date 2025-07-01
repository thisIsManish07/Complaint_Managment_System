package com.flynaut.assignments.Complaint.Management.System.repo;

import com.flynaut.assignments.Complaint.Management.System.Entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepo extends JpaRepository<Complaint,Long> {
}
