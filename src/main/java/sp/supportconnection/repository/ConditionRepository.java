package sp.supportconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.supportconnection.entity.Condition;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
}
