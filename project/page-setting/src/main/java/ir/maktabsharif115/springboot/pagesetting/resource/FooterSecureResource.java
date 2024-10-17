package ir.maktabsharif115.springboot.pagesetting.resource;

import ir.maktabsharif115.springboot.pagesetting.document.Footer;
import ir.maktabsharif115.springboot.pagesetting.service.FooterService;
import ir.maktabsharif115.springboot.pagesetting.service.dto.FooterDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/footer")
@RequiredArgsConstructor
public class FooterSecureResource {

    private final FooterService baseService;

//    private final FooterMapper baseMapper;

    @GetMapping
    @PreAuthorize("hasAuthority(T(ir.maktabsharif115.springboot.usermanagement.constants.AuthorityNames).FOOTER_MANAGE)")
    public ResponseEntity<FooterDTO> get() {
        return ResponseEntity.ok(
//                baseMapper.toDTO(
//                        baseService.get()
//                )
                new FooterDTO(
                        baseService.get().getColumns()
                )
        );
    }

    @PutMapping
    public ResponseEntity<FooterDTO> update(@RequestBody @Valid FooterDTO dto) {
        return ResponseEntity.ok(
//                baseMapper.toDTO(
//                        baseService.update(
//                                baseMapper.toDomain(dto)
//                        )
//                )
                new FooterDTO(
                        baseService.update(
                                new Footer(dto.getColumns())
                        ).getColumns()
                )
        );
    }
}
