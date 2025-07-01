package com.flynaut.assignments.Complaint.Management.System.Entity;

import com.flynaut.assignments.Complaint.Management.System.enums.ComplaintStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;
    private String coustomerName;
    private String issueDescription;
    @Enumerated
    private ComplaintStatus status = ComplaintStatus.OPEN;
    private LocalDateTime raisedOn;
    private LocalDateTime resolverOn;
}
