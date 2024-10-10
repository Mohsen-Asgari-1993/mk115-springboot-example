package ir.maktabsharif115.springboot.rdbms.crud.service.impl;

import ir.maktabsharif115.springboot.rdbms.crud.domain.BaseEntity;
import ir.maktabsharif115.springboot.rdbms.crud.repository.BaseEntityRepository;
import ir.maktabsharif115.springboot.rdbms.crud.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseEntityRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R baseRepository;

    @Override
    public E save(E e) {
        return baseRepository.save(e);
    }

    @Override
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<E> findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    @Override
    public Optional<E> findById(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public long count() {
        return baseRepository.count();
    }

    @Override
    public boolean existsById(ID id) {
        return baseRepository.existsById(id);
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }


}
