package kz.RealIntertop.repository;

import kz.RealIntertop.models.item.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    Collection findCollectionById(Long id);
    Collection findCollectionByName(String name);
    List<Collection> findAllByOrderByBrand();
    List<Collection> findAllByBrandId(Long id);
}
