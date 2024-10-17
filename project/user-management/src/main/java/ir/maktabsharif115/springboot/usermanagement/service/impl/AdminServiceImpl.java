package ir.maktabsharif115.springboot.usermanagement.service.impl;

import ir.maktabsharif115.springboot.usermanagement.annotations.SecurityAuthority;
import ir.maktabsharif115.springboot.usermanagement.constants.AuthorityNames;
import ir.maktabsharif115.springboot.usermanagement.domain.Admin;
import ir.maktabsharif115.springboot.usermanagement.repository.AdminRepository;
import ir.maktabsharif115.springboot.usermanagement.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@SecurityAuthority(name = AuthorityNames.ADMIN_MANAGE)
public class AdminServiceImpl extends BaseUserServiceImpl<Admin, AdminRepository>
        implements AdminService {

    public AdminServiceImpl(AdminRepository baseRepository) {
        super(baseRepository);
    }
}
