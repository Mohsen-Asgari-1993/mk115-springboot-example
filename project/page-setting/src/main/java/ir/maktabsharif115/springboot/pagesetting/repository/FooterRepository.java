package ir.maktabsharif115.springboot.pagesetting.repository;

import ir.maktabsharif115.springboot.mongo.crud.repository.BaseDocumentRepository;
import ir.maktabsharif115.springboot.pagesetting.document.Footer;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterRepository extends BaseDocumentRepository<Footer, String> {
}
