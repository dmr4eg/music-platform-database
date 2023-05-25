package entity;

import entity.primaryKeys.AlbumPK;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "album", schema = "public", catalog = "assyldam")
@IdClass(AlbumPK.class)
public class Album { // DONE
    @Id
    @Column(name = "title", nullable = false)
    private String title;
    @Basic
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;
    @Id
    @ManyToOne
    @JoinColumn(name = "artist", referencedColumnName = "artistid", nullable = false)
    private Artist artistid;
    @Column(name = "amount_od_songs", nullable = false)
    private int amountOdSongs;

    public Album(String title, Date releaseDate, Artist artistid, int amountOdSongs) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artistid = artistid;
        this.amountOdSongs = amountOdSongs;
    }

    public Album() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artistid;
    }

    public void setArtist(Artist artistid) {
        this.artistid = artistid;
    }

    public int getAmountOdSongs() {
        return amountOdSongs;
    }

    public void setAmountOdSongs(int amountOdSongs) {
        this.amountOdSongs = amountOdSongs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album that = (Album) o;
        return artistid == that.artistid && amountOdSongs == that.amountOdSongs && Objects.equals(title, that.title) && Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, artistid, amountOdSongs);
    }
}
