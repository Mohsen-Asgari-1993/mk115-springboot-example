package ir.maktabsharif115.springboot.usermanagement.service;

import ir.maktabsharif115.springboot.usermanagement.domain.Authority;

import java.util.List;
import java.util.Set;

public interface AuthorityService {

    void createIfNotExists(String... name);

    Set<Authority> findAllByNames(List<String> names);
}
