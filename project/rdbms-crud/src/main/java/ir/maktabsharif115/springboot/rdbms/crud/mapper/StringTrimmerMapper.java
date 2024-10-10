package ir.maktabsharif115.springboot.rdbms.crud.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class StringTrimmerMapper {

    public String trimString(String value) {
        return StringUtils.trim(value);
    }
}