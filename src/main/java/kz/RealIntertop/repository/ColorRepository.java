package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Color;
import kz.RealIntertop.model.item.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface ColorRepository extends JpaRepository<Color, Long>  {
    Color findColorByName(String name);
    List<Color> getAllByOrderByName();
    List<Color> findByIdIn(List<Long> ids);
}
