package ir.maktabsharif115.springboot.usermanagement.service.impl;

import ir.maktabsharif115.springboot.usermanagement.domain.BaseUser;
import ir.maktabsharif115.springboot.usermanagement.repository.UserRepository;
import ir.maktabsharif115.springboot.usermanagement.service.RoleService;
import ir.maktabsharif115.springboot.usermanagement.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseUserServiceImpl<BaseUser, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository baseRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        super(baseRepository, roleService, passwordEncoder);
    }
}
