import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        DAO<Album> albumDAO = new DAO<>(Album.class, em);
        DAO<Song> songDAO = new DAO<>(Song.class, em);
        DAO<Artist> artistDAO = new DAO<>(Artist.class, em);
        DAO<Subscription> subscriptionDAO = new DAO<>(Subscription.class, em);
        DAO<Listener> listenerDAO = new DAO<>(Listener.class, em);
        DAO<Playlist> playlistDAO = new DAO<>(Playlist.class, em);

        List<Album> albums = albumDAO.getItems();
        List<Song> songs = songDAO.getItems();
        List<Artist> artists = artistDAO.getItems();
        List<Subscription> subscriptions = subscriptionDAO.getItems();
        List<Listener> listeners = listenerDAO.getItems();
        List<Playlist> playlists = playlistDAO.getItems();


        songDAO.getItems();

        albumDAO.getItems();


//        albumDAO.insert(new Album("album1", "2021-01-01", 1, 1));
//        -------------------------------------
        Artist artist = em.find(Artist.class, 1);

        Genre genre = em.find(Genre.class, 3);

        Song song = new Song();
        song.setTitle("Song Title");
        song.setArtist(artist);
        song.setDuration(new Time(0, 3, 30));
        song.setLanguage("English");
        song.setGenre(genre);
        song.setAlbumTitle("Album Title");

        DAO<Song> songsDAO = new DAO<>(Song.class, em);

        songsDAO.insert(song);


//        -------------------------------------
        Artist artist2 = em.find(Artist.class, 1);

        Genre genre2 = em.find(Genre.class, "rock");

        Song existingSong = songsDAO.get(5);

        existingSong.setTitle("New Title");
        existingSong.setArtist(artist2);
        existingSong.setDuration(new Time(0, 4, 15));
        existingSong.setLanguage("English");
        existingSong.setGenre(genre2);
        existingSong.setAlbumTitle("New Album Title");

        songDAO.update(existingSong);


//        -------------------------------------
        Song existingSong2 = songsDAO.get(12);

        songDAO.delete(existingSong2);

//        -------------------------------------
//        for (Album a : albums)
//            System.out.println(a);

        Song s = new Song(1, "song1", Integer.parseInt("bla"), "1:31", "eng", "Rock", "Lol");
        songDAO.insert(s);
        songDAO.getItems();
    }
}
