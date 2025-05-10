package com.vackDrive.service;

import com.vackDrive.model.UserPrincipal;
import com.vackDrive.model.Users;
import com.vackDrive.repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserDetailRepo userDetailRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userDetailRepo.findByUsername(username);
        if(users==null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        else {
            System.out.println("User details"+ users);
        }

        return new UserPrincipal(users);
    }
}
