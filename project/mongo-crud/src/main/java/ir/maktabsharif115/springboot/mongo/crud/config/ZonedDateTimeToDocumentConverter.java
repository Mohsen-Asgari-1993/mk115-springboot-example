package ir.maktabsharif115.springboot.mongo.crud.config;

import com.mongodb.lang.Nullable;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
@WritingConverter
public class ZonedDateTimeToDocumentConverter implements Converter<ZonedDateTime, Document> {

    public static final String DATE_TIME = "dateTime";
    public static final String ZONE = "zone";
    public static final String MILLIS = "millis";

    @Override
    public Document convert(@Nullable ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) return null;
        Document document = new Document();
        document.put(DATE_TIME, Date.from(zonedDateTime.toInstant()));
        document.put(ZONE, zonedDateTime.getZone().getId());
        document.put(MILLIS, zonedDateTime.toInstant().toEpochMilli());
        return document;
    }
}
