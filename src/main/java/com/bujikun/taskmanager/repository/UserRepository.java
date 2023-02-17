package com.bujikun.taskmanager.repository;

import com.bujikun.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Newton Bujiku
 * @since 2023
 */
public interface UserRepository extends JpaRepository<User,UUID> {
    @Query("SELECT u FROM User u WHERE u.username=:username")
    Optional<User> findUserByUsername(String username);
}
