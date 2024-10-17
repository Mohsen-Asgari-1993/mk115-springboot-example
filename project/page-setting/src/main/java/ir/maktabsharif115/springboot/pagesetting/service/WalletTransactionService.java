package ir.maktabsharif115.springboot.pagesetting.service;

import ir.maktabsharif115.springboot.pagesetting.document.WalletTransaction;
import ir.maktabsharif115.springboot.pagesetting.service.dto.extra.WalletTransactionAggregationDTO;
import ir.maktabsharif115.springboot.pagesetting.service.dto.extra.WalletTransactionSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WalletTransactionService {

    Page<WalletTransaction> findAll(WalletTransactionSearch search, Pageable pageable);

    List<WalletTransactionAggregationDTO> aggregateUserTransactionByPurpose();
}
