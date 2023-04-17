package kz.RealIntertop.repository;

import kz.RealIntertop.models.item.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>  {
    List<Material> getAllByOrderByName();
    List<Material> findByIdIsIn(List<Long> ids);
    Set<Material> searchAllByIdIn(List<Long> ids);
}
