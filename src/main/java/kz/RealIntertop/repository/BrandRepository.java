package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findBrandById(Long id);
    Brand findBrandByName(String name);
    List<Brand> findAllByOrderByName();
}
