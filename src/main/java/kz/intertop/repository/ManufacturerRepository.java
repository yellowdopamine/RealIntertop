package kz.intertop.repository;

import kz.intertop.models.item.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findManufacturerById(Long id);
    Manufacturer findManufacturerByName(String name);
}
