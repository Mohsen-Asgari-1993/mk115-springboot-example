package ir.maktabsharif115.springboot.usermanagement.service.impl;

import ir.maktabsharif115.springboot.usermanagement.repository.AuthorityRepository;
import ir.maktabsharif115.springboot.usermanagement.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository baseRepository;
}
