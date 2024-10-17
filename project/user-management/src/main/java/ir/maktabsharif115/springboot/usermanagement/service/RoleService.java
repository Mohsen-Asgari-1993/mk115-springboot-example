package ir.maktabsharif115.springboot.usermanagement.service;

import ir.maktabsharif115.springboot.usermanagement.domain.Authority;
import ir.maktabsharif115.springboot.usermanagement.domain.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    void createOrUpdate(String name, Set<Authority> authorities);

    Optional<Role> findByName(String name);
}
