package khoi.bui.api_for_angular.repository;

import khoi.bui.api_for_angular.dto.PlaceDto;
import khoi.bui.api_for_angular.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, String> {
    List<Place> findAllByIsUserPlace(boolean isUserPlace);
}
