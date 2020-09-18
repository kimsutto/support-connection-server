package sp.supportconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.supportconnection.entity.AvailableSupport;

public interface AvailableSupportRepository extends JpaRepository<AvailableSupport, Long> {

}