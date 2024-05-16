
package com.example.transactionservice.util;

import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

@Component
public class DateTimeProvider {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'||'HH:mm:ss.SSSXXX");

    public String getCurrentDateTime() {
        return ZonedDateTime.now().format(DATE_TIME_FORMATTER);
    }
}