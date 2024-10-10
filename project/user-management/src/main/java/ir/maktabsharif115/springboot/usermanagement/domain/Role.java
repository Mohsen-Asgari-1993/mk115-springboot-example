package ir.maktabsharif115.springboot.usermanagement.domain;

import ir.maktabsharif115.springboot.rdbms.crud.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Role.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<Long> {

    public static final String TABLE_NAME = "roles";

    public static final String NAME = "name";
    public static final String IS_DEFAULT = "is_default";
    public static final String ROLES_AUTHORITIES = "roles_authorities";
    public static final String ROLE_ID = "role_id";
    public static final String AUTHORITY_ID = "authority_id";

    @Column(name = NAME)
    private String name;

    @Column(name = IS_DEFAULT)
    private Boolean isDefault;

    @ManyToMany
    @JoinTable(
            name = ROLES_AUTHORITIES,
            joinColumns = @JoinColumn(name = ROLE_ID),
            inverseJoinColumns = @JoinColumn(name = AUTHORITY_ID)
    )
    private Set<Authority> authorities = new HashSet<>();
}
