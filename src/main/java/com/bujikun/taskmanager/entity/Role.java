package com.bujikun.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;
/**
 * @author Newton Bujiku
 * @since 2023
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "roles")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true,
    nullable = false)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<Permission> permissions;
    @ManyToMany
    @JoinTable(name ="users_roles",joinColumns = {@JoinColumn(name="fk_user_id",referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name = "fk_role_id",referencedColumnName = "id")} )
    private Set<User> users;
}
