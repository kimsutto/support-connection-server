package sp.supportconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.supportconnection.entity.Support;

import java.util.Optional;

public interface SupportRepository extends JpaRepository<Support, Long> {
    Optional <Support> findSupportBySupportDetailId (Long id);

}
