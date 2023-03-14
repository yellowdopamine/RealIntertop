package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.SubType;
import kz.RealIntertop.model.item.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SubTypeRepository extends JpaRepository<SubType, Long> {
    SubType findSubTypeById(Long id);
    SubType findSubTypeByName(String name);
    List<SubType> findSubTypesByTypeId(Long id);
    List<SubType> findAllByOrderByType();
}
