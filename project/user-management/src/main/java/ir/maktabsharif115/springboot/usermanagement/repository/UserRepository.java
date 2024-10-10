package ir.maktabsharif115.springboot.usermanagement.repository;

import ir.maktabsharif115.springboot.usermanagement.domain.BaseUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseUserRepository<BaseUser> {
}
