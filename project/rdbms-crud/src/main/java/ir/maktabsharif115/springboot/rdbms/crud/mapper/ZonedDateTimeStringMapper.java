package ir.maktabsharif115.springboot.rdbms.crud.mapper;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ZonedDateTimeStringMapper {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public String zoneDateToString(ZonedDateTime date) {
        if (date == null)
            return null;
        return date.format(dateTimeFormatter);
    }

    public ZonedDateTime StringToZoneDate(String date) {
        if (date == null)
            return null;
        return ZonedDateTime.parse(
                date, dateTimeFormatter
        );
    }
}