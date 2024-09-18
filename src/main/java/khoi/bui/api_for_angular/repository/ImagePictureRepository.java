package khoi.bui.api_for_angular.repository;

import khoi.bui.api_for_angular.entity.ImagePicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagePictureRepository extends JpaRepository<ImagePicture, Integer> {
}
