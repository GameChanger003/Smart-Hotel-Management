package com.cts.hotel.Controller;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.JWT.JwtUtil;
import com.cts.hotel.Model.User;
import com.cts.hotel.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;
    
    @GetMapping("/test")
    public String getMethodName() {
        return "Hello Chinnu";
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody User user) {
//    	System.out.println(user);
//        Optional<User> dbUser = userService.findByUsername(user.getId());
//        if (dbUser.isPresent() && passwordEncoder.matches(user.getPassword(), dbUser.get().getPassword())) { 
//            String token = jwtUtil.generateToken(dbUser.get().getId(), dbUser.get().getRole().toString());
//            return ResponseEntity.ok(Collections.singletonMap("token", token));
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> dbUser = userService.findByEmail(user.getEmail()); // ✅ Authenticate via email
        if (dbUser.isPresent() && passwordEncoder.matches(user.getPassword(), dbUser.get().getPassword())) { 
            String token = jwtUtil.generateToken(
                dbUser.get().getEmail(), 
                dbUser.get().getId(), 
                dbUser.get().getRole().toString()
            );
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }



    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
    	System.out.println(user);
        userService.registerUser(user);
        return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
    }
    
//    @PostMapping("/register")
//    public void registerUser(@RequestBody User user) {
//    	System.out.println(user);
//    }
}

