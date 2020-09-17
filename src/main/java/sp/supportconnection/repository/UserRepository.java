package sp.supportconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.supportconnection.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
