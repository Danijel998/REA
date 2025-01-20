package com.example.RealEstateAgency.Security;
import com.example.RealEstateAgency.Entity.UserRegistration;
import com.example.RealEstateAgency.Repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRegistration user = userRegistrationRepository.findByUsername(username);
        if(username == null){
            throw new UsernameNotFoundException("User not found with username: "+username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));

    }

/*
    private Collection<GrantedAuthority> mapRolesToAuthorities(Role role) {
        return List.of(new SimpleGrantedAuthority(role.getRoleName()));
    }*/

   /* private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }*/
}
