package entity.primaryKeys;

import entity.Listener;
import entity.Song;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class ReviewPK implements Serializable { // DONE
    private Date postedDate;
    private int listener;
    private int song;

    public ReviewPK(Date postedDate, int listener, int song) {
        this.postedDate = postedDate;
        this.listener = listener;
        this.song = song;
    }

    public ReviewPK() {
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public int getListener() {
        return listener;
    }

    public void setListener(int listener) {
        this.listener = listener;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewPK that = (ReviewPK) o;
        return listener == that.listener && song == that.song && Objects.equals(postedDate, that.postedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postedDate, listener, song);
    }
}
