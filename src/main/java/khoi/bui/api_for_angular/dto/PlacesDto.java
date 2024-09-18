package khoi.bui.api_for_angular.dto;

import java.util.List;

public class PlacesDto {
    private List<PlaceDto> places;

    public PlacesDto(List<PlaceDto> places) {
        this.places = places;
    }

    public List<PlaceDto> getPlaces() {
        return places;
    }
}
