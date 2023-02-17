package com.bujikun.taskmanager.dto;

import lombok.*;

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
public class TaskDTO {
    private String title;
    private String description;
    private String status;
    private String priority;
    private UUID id;
    private String createdOn;
    private String updatedOn;
}
