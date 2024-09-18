package khoi.bui.api_for_angular.mapper;

import khoi.bui.api_for_angular.dto.ImageDto;
import khoi.bui.api_for_angular.dto.ImagePictureDto;
import khoi.bui.api_for_angular.entity.Image;
import khoi.bui.api_for_angular.entity.ImagePicture;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMapper {
    ImageDto toImageDto(Image image);
    ImagePictureDto toImagePictureDto(ImagePicture imagePicture);
}
