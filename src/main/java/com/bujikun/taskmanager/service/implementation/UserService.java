package com.bujikun.taskmanager.service.implementation;

import com.bujikun.taskmanager.entity.User;
import com.bujikun.taskmanager.repository.UserRepository;
import com.bujikun.taskmanager.service.contract.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService {
    private final UserRepository userRepository;
    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(String id) {

    }

    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }
}
