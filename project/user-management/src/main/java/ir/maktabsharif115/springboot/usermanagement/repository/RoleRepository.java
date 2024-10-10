package ir.maktabsharif115.springboot.usermanagement.repository;

import ir.maktabsharif115.springboot.rdbms.crud.repository.BaseEntityRepository;
import ir.maktabsharif115.springboot.usermanagement.domain.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseEntityRepository<Role, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<Role> findByName(String name);
}
