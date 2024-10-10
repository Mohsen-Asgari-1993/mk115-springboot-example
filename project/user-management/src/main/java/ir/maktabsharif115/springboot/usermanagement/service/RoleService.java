package ir.maktabsharif115.springboot.usermanagement.service;

import ir.maktabsharif115.springboot.usermanagement.domain.Authority;

import java.util.Set;

public interface RoleService {

    void createOrUpdate(String name, Set<Authority> authorities);
}
