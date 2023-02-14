package com.bujikun.taskmanager.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Priority {
    LOW("LOW"),MEDIUM("MEDIUM"),HIGH("HIGH");
    private String value;
}
