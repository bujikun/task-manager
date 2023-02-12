package com.bujikun.taskmanager.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Util {
    public static String formatDateTime(LocalDateTime dateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        var createdOnOptional = Optional.ofNullable(dateTime);
        if(createdOnOptional.isPresent()){
            return df.format(dateTime);
        }
      return null;
    }

}
