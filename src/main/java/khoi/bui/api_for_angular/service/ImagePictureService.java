package khoi.bui.api_for_angular.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import khoi.bui.api_for_angular.entity.ImagePicture;
import khoi.bui.api_for_angular.repository.ImagePictureRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class ImagePictureService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ImagePictureRepository imagePictureRepository;

    @Transactional
    public ImagePicture savePicture(String name) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:image/" + name);
        Blob blob = entityManager.unwrap(Session.class).getLobHelper().createBlob(resource.getInputStream(), resource.contentLength());
        ImagePicture imagePicture = new ImagePicture(blob);
        return imagePictureRepository.save(imagePicture);
    }

    public byte[] getPicture(int id) throws SQLException, IOException {
        Optional<ImagePicture> imagePicture = imagePictureRepository.findById(id);
        if (imagePicture.isPresent()) {
            return imagePicture.get().getData().getBinaryStream().readAllBytes();
        }
        throw new IllegalStateException("There is no picture for the image");
    }
}
