package com.bujikun.taskmanager.entity;

import com.bujikun.taskmanager.enumeration.Priority;
import com.bujikun.taskmanager.enumeration.Status;
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
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, length = 20)
    private Status status;
    @Column(nullable = false, length = 20)
    private Priority priority;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_id",referencedColumnName = "id")
    private User user;
}
