package kz.RealIntertop.repository;

import kz.RealIntertop.models.item.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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

    @Query(value = "" +
            "SELECT item from Item item " +
            "WHERE " +
            "item.modelName LIKE :modelName " +
            "AND item.price BETWEEN :minPrice AND :maxPrice " +
            "AND item.collection.brand.id IN :brandIds " +
            "AND item.subType.type.id IN :typeIds " +
            "AND item.materials IN :materials " +
            "AND item.colors IN :colors " +
            "AND item.gender.id = :genderId " +
            "AND item.isChild = :child " +
            "")
    List<Item> search(
            @Param("modelName") String name,
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice,
            @Param("brandIds") List<Long> brandIds,
            @Param("typeIds") List<Long> typeIds,
            @Param("materials") List<Material> materials,
            @Param("colors") List<Color> colors,
            @Param("child") boolean child
    );

    List<Item> searchItemsByModelNameContainingAndPriceBetweenAndCollectionBrandIdInAndSubTypeTypeIdInAndIsChildAndMaterialsInAndColorsInAndGender(
            String modelName,
            double minPrice, double maxPrice,
            List<Brand> brands, List<Type> types,
            boolean isChild,
            List<Material> materials, List<Color> colors,
            Gender gender
    );


}
