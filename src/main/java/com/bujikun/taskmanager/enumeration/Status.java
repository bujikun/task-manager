package com.bujikun.taskmanager.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    NOT_STARTED("NOT STARTED"),IN_PROGRESS("IN PROGRESS"),COMPLETED("COMPLETED");
    private String value;
}
