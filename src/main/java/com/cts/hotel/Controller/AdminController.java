package com.cts.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.Service.HotelService;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
	@Autowired
	private HotelService hotelService;
	
    @GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "Welcome to Admin Dashboard!";
    }
}

