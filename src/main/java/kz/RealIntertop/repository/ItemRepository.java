package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemByModelNameLike(String name);
    List<Item> findAllByCollectionId(Long id);
    Item findItemById(Long id);

    List<Item> findByModelNameContaining(String modelName);
    List<Item> findByDiscountBetweenAndPriceBetween(int minDiscount, int maxDiscount, double minPrice, double maxPrice);
    List<Item> findByCollectionBrandIdInAndSubTypeIdIn(List<Long> brandIds, List<Long> subTypeIds);
    List<Item> findByIsChild(boolean isChild);
    List<Item> findByArticleContainingIgnoreCase(String article);
    List<Item> findByMaterialsIn(List<Material> materials);
    List<Item> findByColorsIn(List<Color> colors);
    List<Item> findByGender(Gender gender);

    List<Item> findByModelNameContainingAndPriceBetweenAndCollectionBrandIdInAndSubTypeIdInAndIsChildAndMaterialsInAndColorsInAndGender(
            String modelName,
//            int minDiscount, int maxDiscount,
            double minPrice, double maxPrice,
            List<Long> brandIds, List<Long> subTypeIds,
            boolean isChild,
            List<Material> materials, List<Color> colors,
            Gender gender
    );
}
