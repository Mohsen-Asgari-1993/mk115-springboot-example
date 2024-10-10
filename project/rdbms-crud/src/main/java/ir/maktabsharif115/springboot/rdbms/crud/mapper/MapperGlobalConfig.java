package ir.maktabsharif115.springboot.rdbms.crud.mapper;

import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;

@MapperConfig(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ZonedDateTimeLongMapper.class, ZonedDateTimeStringMapper.class, StringTrimmerMapper.class},
        builder = @Builder(disableBuilder = true)
)
@SuppressWarnings("unused")
public interface MapperGlobalConfig {
}