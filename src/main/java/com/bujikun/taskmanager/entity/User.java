package com.bujikun.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Newton Bujiku
 * @since 2023
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, length = 100)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
