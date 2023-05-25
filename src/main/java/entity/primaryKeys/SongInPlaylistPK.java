package entity.primaryKeys;

import entity.Playlist;
import entity.Song;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SongInPlaylistPK implements Serializable { // DONE
    private PlaylistPK playlist;
    private int song;

    public SongInPlaylistPK(PlaylistPK playlist, int song) {
        this.playlist = playlist;
        this.song = song;
    }

    public SongInPlaylistPK() {
    }

    public PlaylistPK getPlaylist() {
        return playlist;
    }

    public int getSongId() {
        return song;
    }

    public void setPlaylist(PlaylistPK playlist) {
        this.playlist = playlist;
    }

    public void setSongId(int song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongInPlaylistPK that = (SongInPlaylistPK) o;
        return song == that.song && Objects.equals(playlist, that.playlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlist, song);
    }
}
