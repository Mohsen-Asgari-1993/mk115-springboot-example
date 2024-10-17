package ir.maktabsharif115.springboot.usermanagement.service.impl;

import ir.maktabsharif115.springboot.usermanagement.annotations.SecurityAuthority;
import ir.maktabsharif115.springboot.usermanagement.constants.AuthorityNames;
import ir.maktabsharif115.springboot.usermanagement.constants.RoleNames;
import ir.maktabsharif115.springboot.usermanagement.domain.Admin;
import ir.maktabsharif115.springboot.usermanagement.domain.Role;
import ir.maktabsharif115.springboot.usermanagement.repository.AdminRepository;
import ir.maktabsharif115.springboot.usermanagement.service.AdminService;
import ir.maktabsharif115.springboot.usermanagement.service.RoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@SecurityAuthority(name = AuthorityNames.ADMIN_MANAGE)
public class AdminServiceImpl extends BaseUserServiceImpl<Admin, AdminRepository>
        implements AdminService {

    public AdminServiceImpl(AdminRepository baseRepository,
                            RoleService roleService,
                            PasswordEncoder passwordEncoder) {
        super(baseRepository, roleService, passwordEncoder);
    }

    @PostConstruct
    public void initAdmin() {
        Optional<Role> optionalAdminRole = roleService.findByName(RoleNames.ADMIN);
        if (optionalAdminRole.isPresent() && baseRepository.count() == 0) {
            Admin admin = new Admin();
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setIsActive(true);
            admin.setUsername("Admin");
            admin.setPassword("123456789");
            admin.setRoles(
                    Set.of(
                            optionalAdminRole.get()
                    )
            );
            baseRepository.save(admin);
        }
    }
}
