package khoi.bui.api_for_angular.dto;

public class ImageDto {
    private String src;
    private String alt;
    private ImagePictureDto imagePicture;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public ImagePictureDto getImagePicture() {
        return imagePicture;
    }

    public void setImagePicture(ImagePictureDto imagePicture) {
        this.imagePicture = imagePicture;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
