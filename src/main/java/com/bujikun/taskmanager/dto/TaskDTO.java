package com.bujikun.taskmanager.dto;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskDTO{
    private String title;
    private String description;
    private Boolean status;
    private UUID slug;
    private String createdOn;
    private String updatedOn;
}
