package ir.maktabsharif115.springboot.usermanagement.init;

import ir.maktabsharif115.springboot.usermanagement.annotations.SecurityAuthority;
import ir.maktabsharif115.springboot.usermanagement.annotations.SecurityRole;
import ir.maktabsharif115.springboot.usermanagement.domain.Authority;
import ir.maktabsharif115.springboot.usermanagement.service.AuthorityService;
import ir.maktabsharif115.springboot.usermanagement.service.RoleService;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DataInitializer extends ClassPathScanningCandidateComponentProvider {

    private RoleService roleService;

    private AuthorityService authorityService;

    public static final String BASE_PACKAGE = "ir.maktabsharif115.springboot";

    public DataInitializer() {
        super(false);
        addIncludeFilter(new AnnotationTypeFilter(SecurityAuthority.class));
        addIncludeFilter(new AnnotationTypeFilter(SecurityRole.class));
    }

    @PostConstruct
    public void init() {
//        AuthorityNames.AUTHS.forEach(
//                authorityService::createIfNotExists
//        );

        Set<BeanDefinition> candidateComponents = findCandidateComponents(BASE_PACKAGE);
        initAuthorities(candidateComponents);
        initRoles(candidateComponents);
    }

    @SneakyThrows
    private void initAuthorities(Set<BeanDefinition> candidateComponents) {
        for (BeanDefinition beanDefinition : candidateComponents) {
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            SecurityAuthority securityAuthority = beanClass.getAnnotation(SecurityAuthority.class);
            if (securityAuthority != null) {
                authorityService.createIfNotExists(securityAuthority.name());
            }
        }
    }

    @SneakyThrows
    private void initRoles(Set<BeanDefinition> candidateComponents) {
        for (BeanDefinition beanDefinition : candidateComponents) {
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            SecurityRole securityRole = beanClass.getAnnotation(SecurityRole.class);
            if (securityRole != null) {
                for (SecurityRole.Role role : securityRole.roles()) {
                    List<String> authorityNames = Arrays.stream(role.authorities()).map(SecurityAuthority::name)
                            .flatMap(Arrays::stream)
                            .collect(Collectors.toList());
                    Set<Authority> authorities = authorityService.findAllByNames(authorityNames);
                    if (authorities == null || authorityNames.size() != authorities.size()) {
                        throw new IllegalStateException("authority not found");
                    }
                    roleService.createOrUpdate(role.name(), authorities);
                }
            }
        }
    }

    @Autowired
    public void setAuthorityService(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
