package ir.maktabsharif115.springboot.rdbms.crud.mapper;

import java.util.List;

public interface BaseMapper<E, D> {

    E toDomain(D d);

    D toDTO(E e);

    List<E> toDomains(List<D> dto);

    List<D> toDTOs(List<E> e);
}
