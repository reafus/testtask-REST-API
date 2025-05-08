package timofeev.testtaskrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timofeev.testtaskrestapi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
