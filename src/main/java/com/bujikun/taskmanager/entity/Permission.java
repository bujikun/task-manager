package com.bujikun.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "permissions")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Permission {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @ManyToMany
    @JoinTable(name = "roles_permissions",joinColumns = {@JoinColumn(name = "fk_role_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "fk_permission_id",referencedColumnName = "id")})
    private Set<Role> roles;
}
