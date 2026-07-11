package ecoclean.service;

import ecoclean.entity.Complaint;
import ecoclean.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private EmailService emailService;

    // Create a new complaint and send the first confirmation email
    public Complaint createComplaint(Complaint complaint) {
        // Generate Unique ID like EC20261234
        String trackingId = "EC2026" + String.format("%04d", new Random().nextInt(10000));
        complaint.setTrackingId(trackingId);
        complaint.setStatus("PENDING");
        
        Complaint savedComplaint = complaintRepository.save(complaint);
        
        // Send Email: "Successfully reached us"
        emailService.sendStatusEmail(savedComplaint.getUserEmail(), savedComplaint.getTrackingId(), "RECEIVED & PENDING");
        
        return savedComplaint;
    }

    // Update status (Admin/HOD side) and send progress updates email
    public Complaint updateComplaintStatus(String trackingId, String newStatus) {
        Complaint complaint = complaintRepository.findByTrackingId(trackingId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        
        complaint.setStatus(newStatus);
        Complaint updatedComplaint = complaintRepository.save(complaint);
        
        // Send Email: "Your complaint is now in progress / cleaned"
        emailService.sendStatusEmail(updatedComplaint.getUserEmail(), updatedComplaint.getTrackingId(), newStatus);
        
        return updatedComplaint;
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
}