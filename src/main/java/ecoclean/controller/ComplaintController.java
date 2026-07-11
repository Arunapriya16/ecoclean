package ecoclean.controller;

import ecoclean.entity.Complaint;
import ecoclean.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "*")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // Endpoint to submit a new complaint
    @PostMapping("/submit")
    public ResponseEntity<Complaint> submitComplaint(@RequestBody Complaint complaint) {
        return ResponseEntity.ok(complaintService.createComplaint(complaint));
    }

    // Endpoint for HOD/Admin to update status (PENDING -> IN_PROGRESS -> CLEANED)
    @PutMapping("/update-status")
    public ResponseEntity<Complaint> updateStatus(@RequestParam String trackingId, @RequestParam String status) {
        return ResponseEntity.ok(complaintService.updateComplaintStatus(trackingId, status));
    }

    // Endpoint to view all complaints on the Admin Dashboard
    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }
}