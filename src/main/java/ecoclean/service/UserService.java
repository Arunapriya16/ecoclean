package ecoclean.service;

import ecoclean.entity.User;
import ecoclean.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to register a new user
    public User registerUser(User user) {
        // Basic check to prevent duplicate emails
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email is already registered!");
        }
        return userRepository.save(user);
    }

    // Method to validate login credentials
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with this email!"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password!");
        }
        
        return user;
    }
}