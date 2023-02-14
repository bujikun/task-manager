package com.bujikun.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
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
