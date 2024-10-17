package ir.maktabsharif115.springboot.pagesetting.mapper;

import ir.maktabsharif115.springboot.pagesetting.document.Footer;
import ir.maktabsharif115.springboot.pagesetting.service.dto.FooterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FooterMapper {

    FooterDTO toDTO(Footer domain);

    Footer toDomain(FooterDTO dto);

}
