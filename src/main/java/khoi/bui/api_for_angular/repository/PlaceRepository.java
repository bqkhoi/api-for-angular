package khoi.bui.api_for_angular.repository;

import khoi.bui.api_for_angular.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, String> {
}
