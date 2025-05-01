package cosplay.spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cosplay.spring.core.entity.Kostum;

@Repository
public interface KostumRepository extends JpaRepository<Kostum, Long> {
}
