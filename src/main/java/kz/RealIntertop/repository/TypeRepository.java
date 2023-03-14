package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findTypeById(Long id);
    Type findTypeByName(String name);
}
