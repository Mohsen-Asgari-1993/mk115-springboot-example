package ir.maktabsharif115.springboot.usermanagement.service.impl;

import ir.maktabsharif115.springboot.usermanagement.annotations.SecurityAuthority;
import ir.maktabsharif115.springboot.usermanagement.constants.AuthorityNames;
import ir.maktabsharif115.springboot.usermanagement.domain.Authority;
import ir.maktabsharif115.springboot.usermanagement.domain.Role;
import ir.maktabsharif115.springboot.usermanagement.repository.RoleRepository;
import ir.maktabsharif115.springboot.usermanagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@SecurityAuthority(name = AuthorityNames.ROLE_MANAGE)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository baseRepository;

    @Override
    @Transactional
    public void createOrUpdate(String name, Set<Authority> authorities) {
        Role role = baseRepository.findByName(name)
                .orElse(new Role());
        role.setName(name);
        role.setAuthorities(authorities);
        role.setIsDefault(true);
        baseRepository.save(role);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return baseRepository.findByName(name);
    }
}
