package cosplay.spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cosplay.spring.core.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}