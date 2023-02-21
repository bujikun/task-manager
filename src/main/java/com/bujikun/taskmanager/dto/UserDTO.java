package com.bujikun.taskmanager.dto;

import lombok.*;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserDTO {
    private String id;
    private String username;
    private String password;
    private String fullName;
    private String createdOn;

}
