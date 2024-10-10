package ir.maktabsharif115.springboot.usermanagement.repository;

import ir.maktabsharif115.springboot.rdbms.crud.repository.BaseEntityRepository;
import ir.maktabsharif115.springboot.usermanagement.domain.Authority;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends BaseEntityRepository<Authority, Long> {
}
