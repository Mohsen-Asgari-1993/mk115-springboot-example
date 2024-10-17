package ir.maktabsharif115.springboot.mongo.crud.repository;

import ir.maktabsharif115.springboot.mongo.crud.document.BaseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseDocumentRepository<E extends BaseDocument<ID>, ID extends Serializable>
        extends MongoRepository<E, ID> {
}
