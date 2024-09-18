package khoi.bui.api_for_angular.mapper;

import khoi.bui.api_for_angular.dto.PlaceDto;
import khoi.bui.api_for_angular.dto.PlacesDto;
import khoi.bui.api_for_angular.entity.Place;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlaceMapper {
    public abstract PlaceDto toPlaceDto(Place place);
    public abstract List<PlaceDto> toListPlaceDto(List<Place> places);

    public PlacesDto toPlacesDto(List<Place> places){
        if ( places == null ) {
            return null;
        }
        List<PlaceDto> listPlaceDto = toListPlaceDto(places);
        return new PlacesDto(listPlaceDto);
    }
}
