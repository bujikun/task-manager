package com.bujikun.taskmanager.enumeration.converter;

import com.bujikun.taskmanager.enumeration.Priority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Priority, String> {
    @Override
    public String convertToDatabaseColumn(Priority priority) {
        if (priority == null) {
            return null;
        }
        return priority.getValue();
    }

    @Override
    public Priority convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Priority.values())
                .filter(p -> p.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
