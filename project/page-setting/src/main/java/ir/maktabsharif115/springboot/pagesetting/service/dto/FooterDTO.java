package ir.maktabsharif115.springboot.pagesetting.service.dto;

import ir.maktabsharif115.springboot.pagesetting.document.FooterColumn;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FooterDTO implements Serializable {

    @Valid
    private List<FooterColumn> columns = new ArrayList<>();

}
