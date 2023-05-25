package entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "song", schema = "public", catalog = "assyldam")
public class Song { // DONE
    @Id
    @Column(name = "song_id")
    private int songId;
    @Basic
    @Column(name = "title", unique = true, nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist", referencedColumnName = "artistID", unique = true, nullable = false)
    private Artist artist;
    @Basic
    @Column(name = "duration", nullable = false)
    private Time duration;
    @Basic
    @Column(name = "language", nullable = false)
    private String language;
    @ManyToOne
    @JoinColumn(name = "genre", referencedColumnName = "name", nullable = false)
    private Genre genre;
    @Column(name = "album_title", unique = true)
    private String albumTitle;

    public Song(int songId, String title, Artist artist, Time duration, String language, Genre genre, String albumTitle) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.language = language;
        this.genre = genre;
        this.albumTitle = albumTitle;
    }

    public Song(int songId, String song1, int i, String s, String eng, String rock, String lol) {

    }

    public Song() {

    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song that = (Song) o;
        return songId == that.songId && artist == that.artist && Objects.equals(title, that.title) && Objects.equals(duration, that.duration) && Objects.equals(language, that.language) && Objects.equals(genre, that.genre) && Objects.equals(albumTitle, that.albumTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, title, artist, duration, language, genre, albumTitle);
    }
}
