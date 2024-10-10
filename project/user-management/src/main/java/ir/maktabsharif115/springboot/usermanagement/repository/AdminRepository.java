package ir.maktabsharif115.springboot.usermanagement.repository;

import ir.maktabsharif115.springboot.usermanagement.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends BaseUserRepository<Admin> {
}
