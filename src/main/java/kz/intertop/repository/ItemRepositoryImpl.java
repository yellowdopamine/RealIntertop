package kz.intertop.repository;

import kz.intertop.models.item.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ItemRepositoryImpl implements ItemRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Set<Item> customSearch(String modelName,
                                  String article,
                                  Double minPrice,
                                  Double maxPrice,
                                  List<Brand> brands,
                                  List<Type> types,
                                  Gender gender,
                                  Boolean child,
                                  List<Material> materials,
                                  List<Color> colors
    ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> query = cb.createQuery(Item.class);
        Root<Item> itemRoot = query.from(Item.class);
        Predicate finalPredicate = cb.conjunction();

        Predicate modelNamePredicate = cb.like(cb.lower(itemRoot.get("modelName")), "%" + modelName.toLowerCase() + "%");
        Predicate articlePredicate = cb.like(cb.lower(itemRoot.get("article")), "%" + article.toLowerCase() + "%");

        finalPredicate = cb.and(finalPredicate, cb.or(modelNamePredicate, articlePredicate));

        if (minPrice != null) {
            finalPredicate = cb.and(finalPredicate, cb.greaterThanOrEqualTo(itemRoot.get("price"), minPrice));
        }

        if (maxPrice != null) {
            finalPredicate = cb.and(finalPredicate, cb.lessThanOrEqualTo(itemRoot.get("price"), maxPrice));
        }

        if (!brands.isEmpty()) {
            finalPredicate = cb.and(finalPredicate, itemRoot.get("brand").in(brands));
        }

        if (!types.isEmpty()) {
            finalPredicate = cb.and(finalPredicate, itemRoot.get("type").in(types));
        }

        if (gender != null) {
            finalPredicate = cb.and(finalPredicate, cb.equal(itemRoot.get("gender"), gender));
        }

        if (child != null) {
            finalPredicate = cb.and(finalPredicate, cb.equal(itemRoot.get("child"), child));
        }

        if (!materials.isEmpty()) {
            finalPredicate = cb.and(finalPredicate, itemRoot.join("materials").in(materials));
        }

        if (!colors.isEmpty()) {
            finalPredicate = cb.and(finalPredicate, itemRoot.join("colors").in(colors));
        }

        query.where(finalPredicate);

        return new HashSet<>(entityManager.createQuery(query).getResultList());
    }
}

