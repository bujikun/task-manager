package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.entity.User;

import java.util.UUID;

public interface IUserService {
    void createUser(User user);
    void updateUser(User user);
    void deleteUserById(String id);
    User findUserById(String id);
    User findUserByUsername(String username);

}
