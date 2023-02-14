package com.bujikun.taskmanager.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@AllArgsConstructor
@Getter
public enum Status {
    NOT_STARTED("NOT STARTED"), IN_PROGRESS("IN PROGRESS"), COMPLETED("COMPLETED");
    private String value;
}
