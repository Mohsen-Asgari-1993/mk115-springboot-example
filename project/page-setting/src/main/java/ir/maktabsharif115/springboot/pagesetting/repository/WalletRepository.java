package ir.maktabsharif115.springboot.pagesetting.repository;

import ir.maktabsharif115.springboot.mongo.crud.repository.BaseDocumentRepository;
import ir.maktabsharif115.springboot.pagesetting.document.Wallet;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends BaseDocumentRepository<Wallet, String> {
}
