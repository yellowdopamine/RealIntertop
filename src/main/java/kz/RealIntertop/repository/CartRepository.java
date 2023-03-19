package kz.RealIntertop.repository;

import kz.RealIntertop.model.item.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartById(Long id);
}
