package ir.maktabsharif115.springboot.rdbms.crud.repository;

import ir.maktabsharif115.springboot.rdbms.crud.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@NoRepositoryBean
@SuppressWarnings({"unused"})
public interface BaseEntityRepository<E extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

    List<E> findAllByCreateDate(ZonedDateTime createDate);

    @Query("select e from #{#entityName} e where e.createDate = :createDate")
    List<E> findAllByCreateDateCustom(@Param("createDate") ZonedDateTime createDate);
}
