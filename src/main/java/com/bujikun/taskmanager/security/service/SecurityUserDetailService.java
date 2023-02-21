package com.bujikun.taskmanager.security.service;

import com.bujikun.taskmanager.entity.User;
import com.bujikun.taskmanager.repository.UserRepository;
import com.bujikun.taskmanager.security.model.SecurityUser;
import com.bujikun.taskmanager.service.implementation.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@Service
@RequiredArgsConstructor
public class SecurityUserDetailService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        return new SecurityUser(user);
    }
}
