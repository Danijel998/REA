package com.example.RealEstateAgency.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/superadmin")
public class SuperAdminController {

    @GetMapping("/dashboard")
    public String superadminDashboard(){
        return "Welcome to superadmin dashboard";
    }

}
