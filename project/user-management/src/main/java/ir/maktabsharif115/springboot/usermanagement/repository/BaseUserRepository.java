package ir.maktabsharif115.springboot.usermanagement.repository;

import ir.maktabsharif115.springboot.rdbms.crud.repository.BaseEntityRepository;
import ir.maktabsharif115.springboot.usermanagement.domain.BaseUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseUserRepository<E extends BaseUser> extends BaseEntityRepository<E, Long> {

    @EntityGraph(attributePaths = {"roles", "roles.authorities"})
    Optional<E> findByUsername(String username);
}
