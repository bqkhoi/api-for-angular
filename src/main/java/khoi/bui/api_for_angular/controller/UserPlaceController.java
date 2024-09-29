package khoi.bui.api_for_angular.controller;

import khoi.bui.api_for_angular.dto.PlaceDto;
import khoi.bui.api_for_angular.dto.PlacesDto;
import khoi.bui.api_for_angular.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-places")
public class UserPlaceController {

    @Autowired
    PlaceService placeService;

    @PutMapping("")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public PlaceDto addUserPlace(@RequestBody String selectedPlaceId){
        return placeService.addUserPlace(selectedPlaceId);
    }

    @GetMapping("")
    public PlacesDto getUserPlaces(){
        return placeService.findUserPlaces();
    }

    @DeleteMapping("/{placeId}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public PlaceDto removeUserPlace(@PathVariable String placeId){
        return placeService.removeUserPlace(placeId);
    }
}
