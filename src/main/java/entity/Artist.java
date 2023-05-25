package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "artist", schema = "public", catalog = "assyldam")
public class Artist { // DONE
    @Id
    @Column(name = "artistid")
    private int artistid;
    @Basic
    @Column(name = "artistemail", unique = true, nullable = false)
    private String artistemail;
    @Basic
    @Column(name = "artistname", unique = true, nullable = false)
    private String artistname;
    @Column(name = "awards", nullable = false)
    private String awards;
    @Basic
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;
    @Basic
    @Column(name = "type", nullable = false)
    private String type;
    @ManyToMany(mappedBy = "artists")
    private Set<Listener> listeners = new HashSet<>();

    public Artist(int artistid, String artistemail, String artistname, String awards, String countryOfOrigin, String password, String type) {
        this.artistid = artistid;
        this.artistemail = artistemail;
        this.artistname = artistname;
        this.awards = awards;
        this.countryOfOrigin = countryOfOrigin;
        this.password = password;
        this.type = type;
    }

    public Artist(){
    }
    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public String getArtistemail() {
        return artistemail;
    }

    public void setArtistemail(String artistemail) {
        this.artistemail = artistemail;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist that = (Artist) o;
        return artistid == that.artistid && Objects.equals(artistemail, that.artistemail) && Objects.equals(artistname, that.artistname) && Objects.equals(awards, that.awards) && Objects.equals(countryOfOrigin, that.countryOfOrigin) && Objects.equals(password, that.password) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistid, artistemail, artistname, awards, countryOfOrigin, password, type);
    }
}
