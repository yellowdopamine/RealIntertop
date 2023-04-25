package kz.intertop.repository;

import kz.intertop.models.item.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {
    List<Item> findAllByCollectionId(Long id);
    Item findItemById(Long id);
}
