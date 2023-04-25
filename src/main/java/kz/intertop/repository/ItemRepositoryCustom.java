package kz.intertop.repository;

import kz.intertop.models.item.*;

import java.util.List;
import java.util.Set;

public interface ItemRepositoryCustom {
    Set<Item> customSearch(String modelName, String article, Double minPrice, Double maxPrice, List<Brand> brands, List<Type> types, Gender gender, Boolean child, List<Material> materials, List<Color> colors);
}

