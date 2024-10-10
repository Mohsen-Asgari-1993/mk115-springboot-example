package ir.maktabsharif115.springboot.usermanagement.service;

import ir.maktabsharif115.springboot.usermanagement.domain.BaseUser;

import java.util.Optional;

public interface BaseUserService<E extends BaseUser> {

    Optional<E> findByUsername(String username);
}
