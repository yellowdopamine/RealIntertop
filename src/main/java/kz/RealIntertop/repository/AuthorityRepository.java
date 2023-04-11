package kz.RealIntertop.repository;

import javax.transaction.Transactional;
import kz.RealIntertop.models.user.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findAuthorityByAuthorityLike(String authority);
}
