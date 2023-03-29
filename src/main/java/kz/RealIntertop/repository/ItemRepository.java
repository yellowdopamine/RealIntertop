package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemByModelNameLike(String name);
    List<Item> findAllByCollectionId(Long id);
    Item findItemById(Long id);

//    Item findItemByPriceBetweenAndCollection_Brand_Id
}
