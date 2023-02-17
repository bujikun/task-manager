package com.bujikun.taskmanager.service.implementation;

import com.bujikun.taskmanager.dto.UserDTO;
import com.bujikun.taskmanager.entity.User;
import com.bujikun.taskmanager.exception.user.UserNotFoundException;
import com.bujikun.taskmanager.repository.UserRepository;
import com.bujikun.taskmanager.service.contract.IUserService;
import com.bujikun.taskmanager.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    Function<User,UserDTO> userToDTO = (u)->{
        return UserDTO.builder()
                .firstName(u.getFirstName())
                .lastName(u.getLastName())
                .email(u.getEmail())
                .createdOn(Util.formatDateTime(u.getCreatedOn()))
                .id(u.getId().toString())
                .build();
    };
    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC,"created_on"))
                .stream()
                .map(userToDTO)
                .toList();
    }
    @Override
    public void createUser(UserDTO userDTO) {
        var user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(String id,UserDTO userDTO) {
        var user = findUserById(id);
          user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(String id) {
        var user = findUserById(id);
        userRepository.delete(user);
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserNotFoundException("User with a given ID: " + id + " not found"));
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with a given username: " + username + " not found"));
    }


}
