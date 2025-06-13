package com.cts.hotel.Service;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> jatin
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.cts.hotel.Model.Role;
=======
>>>>>>> jatin
import com.cts.hotel.Model.User;
import com.cts.hotel.Repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ Register a New User
    public void registerUser(User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty"); // ✅ Prevent null passwords
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // ✅ Encrypt password
        userRepository.save(user);
    }

    // ✅ Find User by Email (Used for login)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // ✅ Find User by ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
<<<<<<< HEAD
    
   public List<User> getAllUsers(){
	   return userRepository.findAll();
   }
   
   public List<User> getUserByRoles(Role role) {
       return userRepository.findByRole(role);
   }
=======
>>>>>>> jatin
}
