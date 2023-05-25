package entity.primaryKeys;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubscriptionPK implements Serializable { // DONE
    private int artistid;
    private int listenerid;

    public SubscriptionPK() {
    }
    public SubscriptionPK(int artistid, int listenerid) {
        this.artistid = artistid;
        this.listenerid = listenerid;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public int getListenerid() {
        return listenerid;
    }

    public void setListenerid(int listenerid) {
        this.listenerid = listenerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionPK that = (SubscriptionPK) o;
        return artistid == that.artistid && listenerid == that.listenerid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistid, listenerid);
    }
}
