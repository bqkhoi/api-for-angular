package khoi.bui.api_for_angular.controller;

import khoi.bui.api_for_angular.entity.ImagePicture;
import khoi.bui.api_for_angular.service.ImagePictureService;
import khoi.bui.api_for_angular.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImagePictureService imagePictureService;


    @GetMapping("/init")
    public void initImages() throws IOException {
        imageService.initData();
    }

    @GetMapping("/{name}")
    public ImagePicture savePicture(@PathVariable String name) throws IOException {
        return imagePictureService.savePicture(name);
    }

    @GetMapping(
        value = "/pictures/{id}",
        produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImagePicture(@PathVariable int id) throws SQLException, IOException {
        return imagePictureService.getPicture(id);
    }
}
