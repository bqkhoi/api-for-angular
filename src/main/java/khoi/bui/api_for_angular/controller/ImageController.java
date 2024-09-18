package khoi.bui.api_for_angular.controller;

import khoi.bui.api_for_angular.entity.ImagePicture;
import khoi.bui.api_for_angular.service.ImagePictureService;
import khoi.bui.api_for_angular.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImagePictureService imagePictureService;


    @GetMapping("/images/init")
    public void initImages() throws IOException {
        imageService.initData();
    }

    @GetMapping("/images/{name}")
    public ImagePicture getImage(@PathVariable String name) throws IOException {
        return imagePictureService.savePicture(name);
    }

    @GetMapping(
        value = "/images/pictures/{id}",
        produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImagePicture(@PathVariable int id) throws SQLException, IOException {
        return imagePictureService.getPicture(id);
    }
}
