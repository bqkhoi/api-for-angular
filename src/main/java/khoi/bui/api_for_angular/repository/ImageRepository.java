package khoi.bui.api_for_angular.repository;

import khoi.bui.api_for_angular.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    public Image findBySrc(String src);
}
