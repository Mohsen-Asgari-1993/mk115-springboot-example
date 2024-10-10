package ir.maktabsharif115.springboot.rdbms.crud.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO<ID extends Serializable> implements Serializable {

    private ID id;

    private String createDate;

    private String lastUpdateDate;
}
