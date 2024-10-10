package ir.maktabsharif115.springboot.usermanagement.repository;

import ir.maktabsharif115.springboot.rdbms.crud.repository.BaseEntityRepository;
import ir.maktabsharif115.springboot.usermanagement.domain.Authority;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface AuthorityRepository extends BaseEntityRepository<Authority, Long> {
    boolean existsByName(String name);

    Set<Authority> findAllByNameIsIn(Collection<String> name);
}
