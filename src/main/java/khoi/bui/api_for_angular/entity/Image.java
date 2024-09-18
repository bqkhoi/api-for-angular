package khoi.bui.api_for_angular.entity;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue
    private int id;
    private String src;
    private String alt;
    @OneToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private ImagePicture imagePicture;

    public void setId(int id) {
        this.id = id;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getId() {
        return id;
    }

    public ImagePicture getImagePicture() {
        return imagePicture;
    }

    public void setImagePicture(ImagePicture imagePicture) {
        this.imagePicture = imagePicture;
    }

    public String getSrc() {
        return src;
    }

    public String getAlt() {
        return alt;
    }

    public Image(String src, String alt) {
        this.src = src;
        this.alt = alt;
    }

    public Image(){}
}
