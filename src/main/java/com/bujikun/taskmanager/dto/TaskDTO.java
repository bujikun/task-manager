package com.bujikun.taskmanager.dto;

import com.bujikun.taskmanager.enumeration.Priority;
import com.bujikun.taskmanager.enumeration.Status;
import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskDTO{
    private String title;
    private String description;
    private String status;
    private String priority;
    private UUID id;
    private String createdOn;
    private String updatedOn;
}
