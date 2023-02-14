package com.bujikun.taskmanager.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@AllArgsConstructor
@Getter
public enum Priority {
    LOW("LOW"), MEDIUM("MEDIUM"), HIGH("HIGH");
    private String value;
}
