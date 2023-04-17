package kz.RealIntertop.repository;

import kz.RealIntertop.models.item.Color;
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
    List<Color> findByIdIsIn(List<Long> ids);
    Set<Color> searchAllByIdIn(List<Long> ids);
}
