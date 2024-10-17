package ir.maktabsharif115.springboot.usermanagement.service.impl;

import ir.maktabsharif115.springboot.usermanagement.domain.BaseUser;
import ir.maktabsharif115.springboot.usermanagement.repository.BaseUserRepository;
import ir.maktabsharif115.springboot.usermanagement.service.BaseUserService;
import ir.maktabsharif115.springboot.usermanagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseUserServiceImpl<E extends BaseUser, R extends BaseUserRepository<E>>
        implements BaseUserService<E> {

    protected final R baseRepository;

    protected final RoleService roleService;

    protected final PasswordEncoder passwordEncoder;

    @Override
    public Optional<E> findByUsername(String username) {
        return baseRepository.findByUsername(username);
    }
}
