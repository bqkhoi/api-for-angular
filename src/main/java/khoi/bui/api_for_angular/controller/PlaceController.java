package khoi.bui.api_for_angular.controller;

import khoi.bui.api_for_angular.dto.PlacesDto;
import khoi.bui.api_for_angular.entity.Place;
import khoi.bui.api_for_angular.mapper.PlaceMapper;
import khoi.bui.api_for_angular.service.PlaceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;


@RestController
public class PlaceController {
    private final PlaceService placeService;
    private final PlaceMapper placeMapper;
    public PlaceController(PlaceService placeService, PlaceMapper placeMapper){
        this.placeService=placeService;
        this.placeMapper = placeMapper;
    }

    @GetMapping("/places/init")
    public void initData(){
         this.placeService.initData();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/places")
    public PlacesDto findAll(){
        List<Place> places=  this.placeService.findAll().stream().sorted(Comparator.comparing(Place::getId, Comparator.comparingInt(String::length))).toList();
        return placeMapper.toPlacesDto(places);
    }
}
