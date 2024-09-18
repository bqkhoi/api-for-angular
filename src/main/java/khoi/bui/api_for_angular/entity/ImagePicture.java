package khoi.bui.api_for_angular.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.sql.Blob;

@Entity
public class ImagePicture {
    @Id
    @GeneratedValue
    private int id;
    @Lob
    private Blob data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getData() {
        return data;
    }

    public void setData(Blob data) {
        this.data = data;
    }

    public ImagePicture(Blob data) {
        this.data = data;
    }

    public ImagePicture() {
    }
}
