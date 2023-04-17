package kz.RealIntertop.repository;

import kz.RealIntertop.models.item.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemByModelNameLike(String name);
    List<Item> findAllByCollectionId(Long id);
    Item findItemById(Long id);

    List<Item> findItemsByModelNameContainsIgnoreCaseAndPriceBetweenAndBrandIsInAndTypeIsInAndGenderIsAndChildIsAndMaterialsInAndColorsIn(
            @Param("modelName") String modelName,
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice,
            @Param("brands") List<Brand> brands,
            @Param("types") List<Type> types,
            @Param("gender") Gender gender,
            @Param("child") boolean child,
            @Param("materials") List<Material> materials,
            @Param("colors") List<Color> colors
    );

    default HashSet<Item> customSearch(
            String modelName,
            String article,
            double minPrice,
            double maxPrice,
            List<Brand> brands,
            List<Type> types,
            Gender gender,
            Boolean child,
            List<Material> materials,
            List<Color> colors
    ){
        HashSet<Item> items = new HashSet<>();

        items.addAll(findItemsByModelNameContainsIgnoreCaseAndPriceBetweenAndBrandIsInAndTypeIsInAndGenderIsAndChildIsAndMaterialsInAndColorsIn(
                modelName,
//                article,
                minPrice,
                maxPrice,
                brands,
                types,
                gender,
                child,
                materials,
                colors
        ));
        return items;
    }

}
