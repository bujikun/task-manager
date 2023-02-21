package com.bujikun.taskmanager.security.model;

import com.bujikun.taskmanager.entity.Permission;
import com.bujikun.taskmanager.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@RequiredArgsConstructor
@Getter
public class SecurityUser implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions()
                        .stream()
                        .map(p -> new SimpleGrantedAuthority(p.getName())))
                .collect(Collectors.toUnmodifiableSet());

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.getIsAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getIsAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getIsCredentialsLocked();
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled();
    }
}
