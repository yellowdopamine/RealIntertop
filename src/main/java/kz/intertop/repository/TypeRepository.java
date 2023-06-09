package kz.intertop.repository;

import kz.intertop.models.item.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findTypeById(Long id);
    Type findTypeByName(String name);
    List<Type> findByIdIsIn(List<Long> ids);
}
