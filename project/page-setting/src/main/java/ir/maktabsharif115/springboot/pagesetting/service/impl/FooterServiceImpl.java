package ir.maktabsharif115.springboot.pagesetting.service.impl;

import ir.maktabsharif115.springboot.pagesetting.document.Footer;
import ir.maktabsharif115.springboot.pagesetting.repository.FooterRepository;
import ir.maktabsharif115.springboot.pagesetting.service.FooterService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FooterServiceImpl implements FooterService {

    private final FooterRepository baseRepository;

    @PostConstruct
    public void init() {
        if (baseRepository.count() == 0) {
            baseRepository.save(new Footer());
        }
    }

    @Override
    public Footer get() {
        return baseRepository.findAll().getFirst();
    }

    @Override
    @PreAuthorize("hasAuthority(T(ir.maktabsharif115.springboot.usermanagement.constants.AuthorityNames).FOOTER_MANAGE)")
    public Footer update(Footer footer) {
        Footer dbFooter = get();
        dbFooter.setColumns(footer.getColumns());
        return baseRepository.save(footer);
    }
}
