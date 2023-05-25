package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "genre", schema = "public", catalog = "assyldam")
public class Genre { // DONE
    @Id
    @Column(name = "genre_id")
    private int genreId;
    @Basic
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;

    public Genre(int genreId, String name, String description) {
        this.genreId = genreId;
        this.name = name;
        this.description = description;
    }

    public Genre() {
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre that = (Genre) o;
        return genreId == that.genreId && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, name, description);
    }
}
