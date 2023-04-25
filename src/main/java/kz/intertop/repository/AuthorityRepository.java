package kz.intertop.repository;

import javax.transaction.Transactional;
import kz.intertop.models.user.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findAuthorityByAuthorityLike(String authority);
}
