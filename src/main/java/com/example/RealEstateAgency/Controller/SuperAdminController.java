package com.example.RealEstateAgency.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/super_admin")
public class SuperAdminController {

    @GetMapping("/dashboard")
    public String superAdminDashboard(){
        return "Welcome to super_admin dashboard";
    }

}
