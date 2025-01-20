package com.example.RealEstateAgency.Controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "Welcome to admin dashboard";
    }

}
