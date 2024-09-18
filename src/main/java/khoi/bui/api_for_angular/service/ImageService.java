package khoi.bui.api_for_angular.service;

import khoi.bui.api_for_angular.entity.Image;
import khoi.bui.api_for_angular.entity.ImagePicture;
import khoi.bui.api_for_angular.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImagePictureService imagePictureService;

    @Transactional
    public void initData() throws IOException {
        List<Image> listImage= new ArrayList<Image>();
        listImage.add(new Image("forest-waterfall.jpg", "A tranquil forest with a cascading waterfall amidst greenery."));
        listImage.add(new Image("desert-dunes.jpg", "Golden dunes stretching to the horizon in the Sahara Desert."));
        listImage.add(new Image("majestic-mountains.jpg", "The sun setting behind snow-capped peaks of majestic mountains."));
        listImage.add(new Image("caribbean-beach.jpg", "Pristine white sand and turquoise waters of a Caribbean beach."));
        listImage.add(new Image("ruins.jpg", "Historic ruins standing tall against the backdrop of the Grecian sky."));
        listImage.add(new Image("rainforest.jpg", "Lush canopy of a rainforest, teeming with life."));
        listImage.add(new Image("northern-lights.jpg", "Dazzling display of the Northern Lights in a starry sky."));
        listImage.add(new Image("japanese-temple.jpg","Ancient Japanese temple surrounded by autumn foliage."));
        listImage.add(new Image("great-barrier-reef.jpg", "Vibrant coral formations of the Great Barrier Reef underwater."));
        listImage.add(new Image("parisian-streets.jpg", "Charming streets of Paris with historic buildings and cafes."));
        listImage.add(new Image("grand-canyon.jpg", "Expansive view of the deep gorges and ridges of the Grand Canyon."));
        listImage.add(new Image("venetian-canals.jpg", "Glistening waters of the Venetian canals as gondolas glide by at sunset."));
        listImage.add(new Image("taj-mahal.jpg", "The iconic Taj Mahal reflecting in its surrounding waters during sunrise."));
        listImage.add(new Image("kerala-backwaters.jpg", "Tranquil waters and lush greenery of the Kerala backwaters."));
        listImage.add(new Image("african-savanna.jpg", "Wild animals roaming freely in the vast landscapes of the African savanna."));
        listImage.add(new Image("victoria-falls.jpg", "The powerful cascade of Victoria Falls, a natural wonder between Zambia and Zimbabwe."));
        listImage.add(new Image("machu-picchu.jpg", "The historic Incan citadel of Machu Picchu illuminated by the morning sun."));
        listImage.add(new Image("amazon-river.jpg", "Navigating the waters of the Amazon River, surrounded by dense rainforest."));

        for (Image image : listImage){
            ImagePicture imagePicture = imagePictureService.savePicture(image.getSrc());
            image.setImagePicture(imagePicture);
        }
        imageRepository.saveAll(listImage);
    }

    public Image findImageBySource(String imageSource){
        return imageRepository.findBySrc(imageSource);
    }
}
