package ir.maktabsharif115.springboot.pagesetting.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String mobileNumber;

    private String userType;

}
