package ir.maktabsharif115.springboot.rdbms.crud.mapper;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class ZonedDateTimeLongMapper {

    public Long zoneDateToLong(ZonedDateTime date) {
        if (date == null)
            return null;
        return date.toInstant().toEpochMilli();
    }

    public ZonedDateTime longToZoneDate(Long date) {
        if (date == null)
            return null;
        return ZonedDateTime.ofInstant(
                Instant.ofEpochMilli(date),
                ZoneId.systemDefault()
        );
    }
}