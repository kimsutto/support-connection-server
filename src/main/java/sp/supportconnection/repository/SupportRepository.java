package sp.supportconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.supportconnection.entity.Support;

public interface SupportRepository extends JpaRepository<Support, Long> {
}
