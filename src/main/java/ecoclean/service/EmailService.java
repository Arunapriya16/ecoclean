package ecoclean.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendStatusEmail(String toEmail, String trackingId, String currentStatus) {
        // This simulates sending an email directly to your terminal console 
        // to avoid dependency compilation issues while keeping your business logic intact.
        System.out.println("=================================================");
        System.out.println("[ECOCLEAN EMAIL NOTIFICATION]");
        System.out.println("To: " + toEmail);
        System.out.println("Subject: EcoClean Complaint Update - " + trackingId);
        System.out.println("Message: Dear User, Your complaint with Tracking ID: " 
                            + trackingId + " is currently: " + currentStatus + ".");
        System.out.println("=================================================");
    }
}