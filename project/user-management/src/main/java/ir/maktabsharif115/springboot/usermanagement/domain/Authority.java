package ir.maktabsharif115.springboot.usermanagement.domain;

import ir.maktabsharif115.springboot.rdbms.crud.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = Authority.TABLE_NAME,
        indexes = @Index(columnList = Authority.NAME, unique = true)
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends BaseEntity<Long> {

    public static final String TABLE_NAME = "authorities";

    public static final String NAME = "name";

    @Column(name = NAME)
    private String name;
}
