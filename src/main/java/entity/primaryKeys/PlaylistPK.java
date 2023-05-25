package entity.primaryKeys;

import entity.Listener;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlaylistPK implements Serializable { // DONE
    private String name;
    private int listenerid;

    public PlaylistPK() {
    }

    public PlaylistPK(String name, int listenerid) {
        this.name = name;
        this.listenerid = listenerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListener() {
        return listenerid;
    }

    public void setListener(int listener) {
        this.listenerid = listener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistPK that = (PlaylistPK) o;
        return listenerid == that.listenerid && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, listenerid);
    }
}
