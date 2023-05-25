package entity;

import entity.primaryKeys.SongInPlaylistPK;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "song_in_playlist", schema = "public", catalog = "assyldam")
@IdClass(SongInPlaylistPK.class)
public class SongInPlaylist { // DONE
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "playlist_name", referencedColumnName = "name", nullable = false),
            @JoinColumn(name = "listenerid", referencedColumnName = "listener", nullable = false)
    })
    private Playlist playlist;

    @Id
    @ManyToOne
    @JoinColumn(name = "song", referencedColumnName = "song_id", nullable = false)
    private Song song;

    public SongInPlaylist() {
    }
    public SongInPlaylist(Playlist playlist, Listener listenerid, Song song) {
        this.playlist = playlist;
        this.song = song;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }


    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongInPlaylist that = (SongInPlaylist) o;
        return song == that.song && Objects.equals(playlist, that.playlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlist, song);
    }
}
