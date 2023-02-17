package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.dto.UserDTO;
import com.bujikun.taskmanager.entity.User;

import java.util.List;

/**
 * @author Newton Bujiku
 * @since 2023
 */

public interface IUserService {
    void createUser(UserDTO user);

    void updateUser(String id, UserDTO user);

    void deleteUserById(String id);

    User findUserById(String id);

    User findUserByUsername(String username);

    List<UserDTO> findAll();

}
