package khoi.bui.api_for_angular.controller;

import khoi.bui.api_for_angular.dto.PlacesDto;
import khoi.bui.api_for_angular.service.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/init")
    public void initData() {
        this.placeService.initData();
    }

//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping("")
    public PlacesDto findAll() {
        return placeService.findAll();
    }
}
