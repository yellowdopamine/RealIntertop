package kz.intertop.repository;

import kz.intertop.models.item.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SeasonRepository extends JpaRepository<Season, Long> {
    Season findSeasonById(Long id);
    Season findSeasonByName(String name);
}
