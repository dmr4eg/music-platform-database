package entity;

import entity.primaryKeys.ReviewPK;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "review", schema = "public", catalog = "assyldam")
@IdClass(ReviewPK.class)
public class Review { // DONE
    @Id
    @Column(name = "posted_date", nullable = false)
    private Date postedDate;

    @Id
    @ManyToOne
    @JoinColumn(name = "listener", referencedColumnName = "listenerID", nullable = false)
    private Listener listener;
    @Id
    @ManyToOne
    @JoinColumn(name = "song", referencedColumnName = "song_id", nullable = false)
    private Song song;
    @Basic
    @Column(name = "rate", nullable = false)
    private int rate;
    @Basic
    @Column(name = "review_text", nullable = false)
    private String reviewText;

    public Review(Date postedDate, Listener listener, Song song, int rate, String reviewText) {
        this.postedDate = postedDate;
        this.listener = listener;
        this.song = song;
        this.rate = rate;
        this.reviewText = reviewText;
    }

    public Review() {
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review that = (Review) o;
        return listener == that.listener && song == that.song && rate == that.rate && Objects.equals(postedDate, that.postedDate) && Objects.equals(reviewText, that.reviewText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postedDate, listener, song, rate, reviewText);
    }
}
