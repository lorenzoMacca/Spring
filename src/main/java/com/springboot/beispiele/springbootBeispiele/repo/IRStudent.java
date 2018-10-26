package com.springboot.beispiele.springbootBeispiele.repo;

import com.springboot.beispiele.springbootBeispiele.entities.EStudent;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRStudent extends JpaRepository<EStudent, Long> {
}


/**
 *
 * JpaRepository
 *  |
 *   ----- PagingAndSortingRepository
 *            |
 *             ------ CrudRepository
 *
 *
 * We are extending JpaRepository using two generics - Student & Long. Student is the entity that is being managed
 * and the primary key of Student is Long.
 * JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository interface. So, JpaRepository
 * inherits all the methods from the two interfaces shown below
 * public abstract interface PagingAndSortingRepository extends CrudRepository {
 *
 *   public abstract Iterable findAll(Sort arg0);
 *
 *   public abstract Page findAll(Pageable arg0);
 *
 * }
 *
 * public interface CrudRepository<T, ID extends Serializable>
 *     extends Repository<T, ID> {
 *
 *     <S extends T> S save(S entity);
 *
 *     T findOne(ID primaryKey);
 *
 *     Iterable<T> findAll();
 *
 *     Long count();
 *
 *     void delete(T entity);
 *
 *     boolean exists(ID primaryKey);
 *
 *     // … more functionality omitted.
 * }
 */