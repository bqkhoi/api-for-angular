package khoi.bui.api_for_angular.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class Place {
    @Id
    private String id;
    private String title;
    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;
    private double lat;
    private double lon;
    private boolean isUserPlace=false;

    public boolean isUserPlace() {
        return isUserPlace;
    }

    public void setUserPlace(boolean userPlace) {
        isUserPlace = userPlace;
    }

    public Place(String id, String title, Image image, double lat, double lon) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Place(){}

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Image getImage() {
        return image;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
