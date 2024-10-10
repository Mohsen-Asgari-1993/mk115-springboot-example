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
@Table(
        name = BaseUser.TABLE_NAME,
        indexes = {
                @Index(columnList = BaseUser.USERNAME_INDEX_COLUMNS, unique = true)
        }
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = BaseUser.DISCRIMINATOR)
@DiscriminatorValue(value = BaseUser.DISCRIMINATOR_VALUE)
public class BaseUser extends BaseEntity<Long> {

    public static final String TABLE_NAME = "users";

    public static final String DISCRIMINATOR_VALUE = "BaseUser";
    public static final String DISCRIMINATOR = "discriminator";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String IS_ACTIVE = "is_active";
    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String USERS_ROLES = "users_roles";
    public static final String USER_ID = "user_id";
    public static final String ROLE_ID = "role_id";

    public static final String USERNAME_INDEX_COLUMNS = DISCRIMINATOR + ", " + USERNAME;

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USERNAME)
    private String username;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = MOBILE_NUMBER)
    private String mobileNumber;

    @Column(name = IS_ACTIVE)
    private Boolean isActive = false;

    @ManyToMany
    @JoinTable(
            name = USERS_ROLES,
            joinColumns = @JoinColumn(name = USER_ID),
            inverseJoinColumns = @JoinColumn(name = ROLE_ID)
    )
    private Set<Role> roles = new HashSet<>();

}
