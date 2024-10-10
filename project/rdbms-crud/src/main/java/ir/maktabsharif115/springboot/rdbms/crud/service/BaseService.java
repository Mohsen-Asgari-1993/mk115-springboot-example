package ir.maktabsharif115.springboot.rdbms.crud.service;

import ir.maktabsharif115.springboot.rdbms.crud.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    List<E> findAll();

    List<E> findAll(Sort sort);

    Page<E> findAll(Pageable pageable);

    Optional<E> findById(ID id);

    long count();

    boolean existsById(ID id);

    void deleteById(ID id);


}
