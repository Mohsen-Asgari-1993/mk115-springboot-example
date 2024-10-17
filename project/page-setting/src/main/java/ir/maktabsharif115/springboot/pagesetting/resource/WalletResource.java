package ir.maktabsharif115.springboot.pagesetting.resource;

import ir.maktabsharif115.springboot.pagesetting.document.WalletTransaction;
import ir.maktabsharif115.springboot.pagesetting.service.WalletTransactionService;
import ir.maktabsharif115.springboot.pagesetting.service.dto.extra.WalletTransactionSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletResource {

    private final WalletTransactionService walletTransactionService;

    @PostMapping("/transaction/search/pageable")
    public ResponseEntity<Page<WalletTransaction>> findAll(@RequestBody WalletTransactionSearch search,
                                                           Pageable pageable) {
        return ResponseEntity.ok(
                walletTransactionService.findAll(search, pageable)
        );
    }
}
