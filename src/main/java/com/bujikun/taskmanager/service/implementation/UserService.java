package com.bujikun.taskmanager.service.implementation;

import com.bujikun.taskmanager.dto.UserDTO;
import com.bujikun.taskmanager.entity.Role;
import com.bujikun.taskmanager.entity.User;
import com.bujikun.taskmanager.exception.user.UserNotFoundException;
import com.bujikun.taskmanager.repository.UserRepository;
import com.bujikun.taskmanager.service.contract.IUserService;
import com.bujikun.taskmanager.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author Newton Bujiku
 * @since 2023
 */

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    Function<User,UserDTO> userToDTO = (u)->{
        return UserDTO.builder()
                .fullName(u.getFullName())
                .username(u.getUsername())
                .createdOn(Util.formatDateTime(u.getCreatedOn()))
                .id(u.getId().toString())
                .build();
    };
    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC,"createdOn"))
                .stream()
                .map(userToDTO)
                .toList();
    }
    @Override
    public void createUser(UserDTO userDTO) {
        var roles = new HashSet<Role>();
        var role = new Role();
        role.setId(2);
        roles.add(role);
        var user = User.builder()
                .fullName(userDTO.getFullName())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .username(userDTO.getUsername())
                .isAccountExpired(false)
                .isEnabled(true)
                .isAccountLocked(false)
                .isCredentialsLocked(false)
                .roles(roles)
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(String id,UserDTO userDTO) {
        var user = findUserById(id);
          user.setFullName(userDTO.getFullName());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(String id) {
        var user = findUserById(id);
        userRepository.delete(user);
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new UserNotFoundException("User with a given ID: " + id + " not found"));
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with a given username: " + username + " not found"));
    }


}
