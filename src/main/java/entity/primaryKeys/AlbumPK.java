package entity.primaryKeys;

import entity.Artist;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlbumPK implements Serializable { // DONE
    private String title;
    private int artistid;

    public AlbumPK() {

    }
    public AlbumPK(String title, int artistid) {
        this.title = title;
        this.artistid = artistid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtist() {
        return artistid;
    }

    public void setArtist(int artistid) {
        this.artistid = artistid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumPK that = (AlbumPK) o;
        return artistid == that.artistid && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artistid);
    }
}
