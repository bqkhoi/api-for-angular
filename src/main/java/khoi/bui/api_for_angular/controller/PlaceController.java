package khoi.bui.api_for_angular.controller;

import khoi.bui.api_for_angular.dto.PlacesDto;
import khoi.bui.api_for_angular.entity.Place;
import khoi.bui.api_for_angular.mapper.PlaceMapper;
import khoi.bui.api_for_angular.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;
    private final PlaceMapper placeMapper;
    public PlaceController(PlaceService placeService, PlaceMapper placeMapper){
        this.placeService=placeService;
        this.placeMapper = placeMapper;
    }

    @GetMapping("/init")
    public void initData(){
         this.placeService.initData();
    }

    //@ResponseBody
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("")
    public PlacesDto findAll(){
        return placeService.findAll();
    }
}
