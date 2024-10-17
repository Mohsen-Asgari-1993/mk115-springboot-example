package ir.maktabsharif115.springboot.pagesetting.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String USERNAME = "username";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String USER_TYPE = "userType";

    @Field(ID)
    private Long id;

    @Field(FIRST_NAME)
    private String firstName;

    @Field(LAST_NAME)
    private String lastName;

    @Field(USERNAME)
    private String username;

    @Field(MOBILE_NUMBER)
    private String mobileNumber;

    @Field(USER_TYPE)
    private String userType;

}
