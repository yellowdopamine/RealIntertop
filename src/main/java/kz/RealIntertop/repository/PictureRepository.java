package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findPictureByName(String name);
}
