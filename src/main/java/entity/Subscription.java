package entity;

import entity.primaryKeys.SubscriptionPK;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "subscription", schema = "public", catalog = "assyldam")
@IdClass(SubscriptionPK.class)
public class Subscription { // DONE
    @Id
    @ManyToOne
    @JoinColumn(name = "artistID", insertable = true, updatable = true)
    private Artist artistid;
    @Id
    @ManyToOne
    @JoinColumn(name = "listenerID", insertable = true, updatable = true)
    private Listener listenerid;

    public Subscription() {
    }
    public Subscription(Artist artistid, Listener listenerid) {
        this.artistid = artistid;
        this.listenerid = listenerid;
//        this.id = new SubscriptionPK(artistid.getArtistid(), listenerid.getListenerid());
    }

    public Artist getArtistid() {
        return artistid;
    }

    public void setArtistid(Artist artistid) {
        this.artistid = artistid;
    }

    public Listener getListenerid() {
        return listenerid;
    }

    public void setListenerid(Listener listenerid) {
        this.listenerid = listenerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return artistid == that.artistid && listenerid == that.listenerid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistid, listenerid);
    }

//    public void setId(SubscriptionPK id) {
//        this.id = id;
//    }
//
//    public SubscriptionPK getId() {
//        return id;
//    }
}
