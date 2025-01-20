package com.example.RealEstateAgency.Controller;

import com.example.RealEstateAgency.DTO.AuthResponseDTO;
import com.example.RealEstateAgency.DTO.LoginDTO;
import com.example.RealEstateAgency.DTO.RegisterDTO;
import com.example.RealEstateAgency.Entity.AuthenticationRequest;
import com.example.RealEstateAgency.Entity.UserEntity;
import com.example.RealEstateAgency.Repository.RoleRepository;
import com.example.RealEstateAgency.Repository.UserEntityRepository;
import com.example.RealEstateAgency.Repository.UserRegistrationRepository;
import com.example.RealEstateAgency.Security.AuthenticationResponse;
import com.example.RealEstateAgency.Security.CustomUserDetailsService;
import com.example.RealEstateAgency.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(jwt, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthenticationResponse(null,"Invalid username or password "+ e.getMessage()));
        }
    }
}
