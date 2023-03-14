package kz.RealIntertop.repository;

import javax.transaction.Transactional;
import kz.RealIntertop.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    boolean existsUserByEmail(String email);
    User getUserById(Long id);
}
