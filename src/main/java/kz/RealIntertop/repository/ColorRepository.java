package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ColorRepository extends JpaRepository<Color, Long>  {
    Color findColorByName(String name);
    List<Color> getAllByOrderByName();
}
