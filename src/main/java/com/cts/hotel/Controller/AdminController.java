package com.cts.hotel.Controller;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Service.UserService;
import com.cts.hotel.Model.Role;
import com.cts.hotel.Model.User;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Service.HotelService;
>>>>>>> jatin

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
<<<<<<< HEAD
	
	@Autowired
	private UserService userService;
    
	@GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "Welcome to Admin Dashboard!";
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAdminAllUsers() {
    	List<User> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/users/Managers")
    public ResponseEntity<List<User>> getAdminManagerUsers() {
    	List<User> users=userService.getUserByRoles(Role.MANAGER);
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/users/Guests")
    public ResponseEntity<List<User>> getAdminGuestUsers() {
    	List<User> users=userService.getUserByRoles(Role.GUEST);
        return ResponseEntity.ok(users);
    }
    
    @PostMapping("/users/")
    public ResponseEntity<List<User>> getAdminGuestUsers1() {
    	List<User> users=userService.getUserByRoles(Role.GUEST);
        return ResponseEntity.ok(users);
    }
=======
	@Autowired
	private HotelService hotelService;
	
    @GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "Welcome to Admin Dashboard!";
    }
>>>>>>> jatin
}

