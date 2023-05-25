package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "listener", schema = "public", catalog = "assyldam")
public class Listener { // DONE
    @Id
    @Column(name = "listenerid")
    private int listenerid;
    @Column(name = "listeneremail", unique = true, nullable = false)
    private String listeneremail;
    @Basic
    @Column(name = "listenername", nullable = false)
    private String listenername;
    @Basic
    @Column(name = "songs_added", nullable = false)
    private int songsAdded;
    @Basic
    @Column(name = "preferences", nullable = false)
    private String preferences;
    @Basic
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Basic

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "subscription",
            joinColumns = @JoinColumn(name = "listenerID"),
            inverseJoinColumns = @JoinColumn(name = "artistID")
    )
    private Set<Artist> artists = new HashSet<>();


    public Listener(int listenerid, String listeneremail, String listenername, int songsAdded, String preferences, String countryOfOrigin, String password) {
        this.listenerid = listenerid;
        this.listeneremail = listeneremail;
        this.listenername = listenername;
        this.songsAdded = songsAdded;
        this.preferences = preferences;
        this.countryOfOrigin = countryOfOrigin;
        this.password = password;
    }

    public Listener() {
    }

    public int getListenerid() {
        return listenerid;
    }

    public void setListenerid(int listenerid) {
        this.listenerid = listenerid;
    }

    public String getListeneremail() {
        return listeneremail;
    }

    public void setListeneremail(String listeneremail) {
        this.listeneremail = listeneremail;
    }

    public String getListenername() {
        return listenername;
    }

    public void setListenername(String listenername) {
        this.listenername = listenername;
    }

    public int getSongsAdded() {
        return songsAdded;
    }

    public void setSongsAdded(int songsAdded) {
        this.songsAdded = songsAdded;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listener that = (Listener) o;
        return listenerid == that.listenerid && songsAdded == that.songsAdded && Objects.equals(listeneremail, that.listeneremail) && Objects.equals(listenername, that.listenername) && Objects.equals(preferences, that.preferences) && Objects.equals(countryOfOrigin, that.countryOfOrigin) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listenerid, listeneremail, listenername, songsAdded, preferences, countryOfOrigin, password);
    }
}
