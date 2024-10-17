package ir.maktabsharif115.springboot.usermanagement.init;

import ir.maktabsharif115.springboot.usermanagement.annotations.SecurityAuthority;
import ir.maktabsharif115.springboot.usermanagement.annotations.SecurityRole;
import ir.maktabsharif115.springboot.usermanagement.constants.AuthorityNames;
import ir.maktabsharif115.springboot.usermanagement.constants.RoleNames;
import org.springframework.stereotype.Component;

@Component
@SecurityAuthority(
        name = {
                AuthorityNames.ADMIN_MANAGE,
                AuthorityNames.ROLE_MANAGE,
                AuthorityNames.FOOTER_MANAGE,
                AuthorityNames.WALLET_MANAGE,
        }
)
@SecurityRole(
        roles = {
                @SecurityRole.Role(
                        name = RoleNames.ADMIN,
                        authorities = {
                                @SecurityAuthority(name = {
                                        AuthorityNames.ADMIN_MANAGE,
                                        AuthorityNames.ROLE_MANAGE,
                                        AuthorityNames.FOOTER_MANAGE,
                                        AuthorityNames.WALLET_MANAGE,
                                })
                        }
                )
        }
)
@SuppressWarnings("unused")
public class RoleAutoDeployer {
}
