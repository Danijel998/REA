package com.example.RealEstateAgency.Security;

import com.example.RealEstateAgency.Entity.UserRegistration;
import com.example.RealEstateAgency.Repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
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
        Optional<UserRegistration> user = userRegistrationRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        UserRegistration u = user.get();
        return new User(
                u.getUsername(),
                u.getPassword(),
                getAuthorities(u)
                //Collections.singletonList(new SimpleGrantedAuthority(u.getRole()))
        );

    }


    private Collection<? extends  GrantedAuthority> getAuthorities(UserRegistration user) {
        return AuthorityUtils.createAuthorityList("ROLE_"+user.getRole().toString());
    }

   /* private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }*/
}
