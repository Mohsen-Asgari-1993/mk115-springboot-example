package ir.maktabsharif115.springboot.usermanagement.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue(Admin.DISCRIMINATOR_VALUE)
public class Admin extends BaseUser {

    public static final String DISCRIMINATOR_VALUE = "Admin";


}
