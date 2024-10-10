package ir.maktabsharif115.springboot.usermanagement.service.impl;

import ir.maktabsharif115.springboot.usermanagement.domain.Authority;
import ir.maktabsharif115.springboot.usermanagement.repository.AuthorityRepository;
import ir.maktabsharif115.springboot.usermanagement.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository baseRepository;

    @Override
    @Transactional
    public void createIfNotExists(String[] name) {
        for (String authorityName : name) {
            if (!baseRepository.existsByName(authorityName)) {
                baseRepository.save(new Authority(authorityName));
            }
        }
    }

    @Override
    public Set<Authority> findAllByNames(List<String> names) {
        return baseRepository.findAllByNameIsIn(names);
    }
}
