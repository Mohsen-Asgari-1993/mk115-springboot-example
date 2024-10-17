package ir.maktabsharif115.springboot.mongo.crud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoCustomConversions customConversions() {

        List<Converter<?, ?>> converters = new ArrayList<>();

        converters.add(new ZonedDateTimeToDocumentConverter());
        converters.add(new DocumentToZonedDateTimeConverter());

        return new MongoCustomConversions(converters);
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }

}
