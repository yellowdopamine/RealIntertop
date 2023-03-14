package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findGenderByName(Long id);
    Gender findGenderById(Long id);
}
