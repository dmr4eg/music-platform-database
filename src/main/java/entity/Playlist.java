package entity;

import entity.primaryKeys.PlaylistPK;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "playlist", schema = "public", catalog = "assyldam")
@IdClass(PlaylistPK.class)
public class Playlist { // DONE
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Id
    @ManyToOne
    @JoinColumn(name = "listener", referencedColumnName = "listenerid", nullable = false)
    private Listener listenerid;
    @Column(name = "date_of_creation", nullable = false)
    private Date dateOfCreation;
    @Column(name = "amount_od_songs", nullable = false)
    private int amountOdSongs;
    @Column(name = "privacy", nullable = false)
    private String privacy;

    public Playlist(String name, Listener listenerid, Date dateOfCreation, int amountOdSongs, String privacy) {
        this.name = name;
        this.listenerid = listenerid;
        this.dateOfCreation = dateOfCreation;
        this.amountOdSongs = amountOdSongs;
        this.privacy = privacy;
    }

    public Playlist() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Listener getListener() {
        return listenerid;
    }

    public void setListener(Listener listenerid) {
        this.listenerid = listenerid;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getAmountOdSongs() {
        return amountOdSongs;
    }

    public void setAmountOdSongs(int amountOdSongs) {
        this.amountOdSongs = amountOdSongs;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist that = (Playlist) o;
        return listenerid == that.listenerid && amountOdSongs == that.amountOdSongs && Objects.equals(name, that.name) && Objects.equals(dateOfCreation, that.dateOfCreation) && Objects.equals(privacy, that.privacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, listenerid, dateOfCreation, amountOdSongs, privacy);
    }
}
