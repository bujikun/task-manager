package com.bujikun.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 100)
    private String fullName;
    private Boolean isAccountExpired;
    private Boolean isAccountLocked;
    private Boolean isCredentialsLocked;
    private Boolean isEnabled;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "fk_user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_role_id", referencedColumnName = "id")})
    private Set<Role> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Task> tasks;
}
