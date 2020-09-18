package sp.supportconnection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.supportconnection.entity.Asset;
import sp.supportconnection.entity.AvailableSupport;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}