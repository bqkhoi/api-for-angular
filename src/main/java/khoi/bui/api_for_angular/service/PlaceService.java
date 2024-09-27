package khoi.bui.api_for_angular.service;

import khoi.bui.api_for_angular.dto.PlaceDto;
import khoi.bui.api_for_angular.dto.PlacesDto;
import khoi.bui.api_for_angular.entity.Place;
import khoi.bui.api_for_angular.mapper.PlaceMapper;
import khoi.bui.api_for_angular.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private PlaceMapper placeMapper;

    public void initData() {
        List<Place> places = new ArrayList<>();
        places.add(new Place("p1", "Forest Waterfall", imageService.findImageBySource("forest-waterfall.jpg"), 44.5588, -80.344));
        places.add(new Place("p2", "Sahara Desert Dunes", imageService.findImageBySource("desert-dunes.jpg"), 25.0, 0.0));
        places.add(new Place("p3", "Himalayan Peaks", imageService.findImageBySource("majestic-mountains.jpg"), 27.9881, 86.925));
        places.add(new Place("p4", "Caribbean Beach", imageService.findImageBySource("caribbean-beach.jpg"), 18.2208, -66.5901));
        places.add(new Place("p5", "Ancient Grecian Ruins", imageService.findImageBySource("ruins.jpg"), 37.9715, 23.7257));
        places.add(new Place("p6", "Amazon Rainforest Canopy", imageService.findImageBySource("rainforest.jpg"), -3.4653, -62.2159));
        places.add(new Place("p7", "Northern Lights", imageService.findImageBySource("northern-lights.jpg"), 64.9631, -19.0208));
        places.add(new Place("p8", "Japanese Temple", imageService.findImageBySource("japanese-temple.jpg"), 34.9949, 135.785));
        places.add(new Place("p9", "Great Barrier Reef", imageService.findImageBySource("great-barrier-reef.jpg"), -18.2871, 147.6992));
        places.add(new Place("p10", "Parisian Streets", imageService.findImageBySource("parisian-streets.jpg"), 48.8566, 2.3522));
        places.add(new Place("p11", "Grand Canyon", imageService.findImageBySource("grand-canyon.jpg"), 36.1069, -112.1129));
        places.add(new Place("p12", "Venetian Canals", imageService.findImageBySource("venetian-canals.jpg"), 45.4408, 12.3155));
        places.add(new Place("p13", "Taj Mahal", imageService.findImageBySource("taj-mahal.jpg"), 27.1751, 78.0421));
        places.add(new Place("p14", "Kerala Backwaters", imageService.findImageBySource("kerala-backwaters.jpg"), 9.4981, 76.3388));
        places.add(new Place("p15", "African Savanna", imageService.findImageBySource("african-savanna.jpg"), -2.153, 34.6857));
        places.add(new Place("p16", "Victoria Falls", imageService.findImageBySource("victoria-falls.jpg"), -17.9243, 25.8572));
        places.add(new Place("p17", "Machu Picchu", imageService.findImageBySource("machu-picchu.jpg"), -13.1631, -72.545));
        places.add(new Place("p18", "Amazon River", imageService.findImageBySource("amazon-river.jpg"), -3.4653, -58.38));

        placeRepository.saveAll(places);
    }

    public PlacesDto findAll() {
        List<Place> places = placeRepository.findAll().stream()
                .sorted(Comparator.comparing(Place::getId, Comparator.comparingInt(String::length)))
                .toList();
        return placeMapper.toPlacesDto(places);
    }

    public PlaceDto addUserPlace(String placeId) {
        Optional<Place> place = placeRepository.findById(placeId);
        place.ifPresentOrElse(
                existedPlace -> existedPlace.setUserPlace(true),
                () -> {
                    throw new IllegalStateException("This place is not existed");
                }
        );
        return placeMapper.toPlaceDto(placeRepository.save(place.get()));
    }

    public PlaceDto removeUserPlace(String placeId) {
        Optional<Place> place = placeRepository.findById(placeId);
        place.ifPresentOrElse(
                existedPlace -> existedPlace.setUserPlace(false),
                () -> {
                    throw new IllegalStateException("This place is not existed");
                }
        );
        return placeMapper.toPlaceDto(placeRepository.save(place.get()));
    }

    public PlacesDto findUserPlaces() {
        return placeMapper.toPlacesDto(placeRepository.findAllByIsUserPlace(true));
    }
}
