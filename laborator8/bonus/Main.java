package org.example;

import org.example.DAO.AlbumDAO;
import org.example.DAO.ArtistDAO;
import org.example.DAO.GenreDAO;
import org.example.DAO.PlaylistDAO;
import org.example.connection.Database;
import org.example.objectModel.Album;
import org.example.objectModel.Artist;
import org.example.objectModel.Genre;
import org.example.objectModel.Playlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Database.deleteAll("artists");
            Database.deleteAll("playlists_albums");
            Database.deleteAll("albums");
            Database.deleteAll("genres");
            Database.deleteAll("playlists");

            var artists = new ArtistDAO();
            Artist art1 = new Artist(1, "Pink Floyd");
            Artist art2 = new Artist(2, "Michael Jackson");
            Artist art3 = new Artist(3, "The Beatles");
            Artist art4 = new Artist(4, "Elvis Presley");
            Artist art5 = new Artist(5, "The Smiths");
            Artist art6 = new Artist(6, "Liam Lame");
            Artist art7 = new Artist(7, "Blabla Band");
            artists.create(art1);artists.create(art2);artists.create(art3);artists.create(art4);artists.create(art5);artists.create(art6);artists.create(art7);
            Database.getConnection().commit();
            //System.out.println("Trying to find Michael Jackson: " + artists.findByName("Michael Jackson"));
            var genres = new GenreDAO();
            var g1 = new Genre(1,"Rock");
            var g2 = new Genre(2,"Funk");
            var g3 = new Genre(3,"Soul");
            var g4 = new Genre(4,"Pop");
            genres.create(g1);
            genres.create(g2);
            genres.create(g3);
            genres.create(g4);
            //System.out.println("The third genre: " + genres.findById(3));
            Database.getConnection().commit();

            var albums = new AlbumDAO();
            Album alb1 = new Album(1, 1979, "The Wall", "Pink Floyd", "Rock");
            Album alb2 = new Album(2, 1982, "Thriller", "Michael Jackson","Funk, Soul, Pop");
            Album alb3 = new Album(3, 1967, "Sgt. Pepper's Lonely Hearts Club Band", "The Beatles","Rock");
            Album alb4 = new Album(4, 1976, "The Sun Sessions", "Elvis Presley","Rock");
            Album alb5 = new Album(5, 1984, "The Smiths", "The Smiths","Rock");
            Album alb6 = new Album(6, 1982, "Boredom", "Liam Lame","Pop");
            Album alb7 = new Album(7, 2000, "Something silly", "Blabla Band","Soul");
            albums.create(alb1);albums.create(alb2);albums.create(alb3);albums.create(alb4);albums.create(alb5);albums.create(alb6);albums.create(alb7);
            //System.out.println("Trying to find The Wall: " + albums.findByName("The Wall"));
            Database.getConnection().commit();

            List<Album> albumList1 = new ArrayList<>();albumList1.add(alb1);albumList1.add(alb2);
            List<Album> albumList2 = new ArrayList<>();albumList2.add(alb2);albumList2.add(alb3);albumList2.add(alb4);
            List<Album> albumList3 = new ArrayList<>();albumList3.add(alb1);albumList3.add(alb2);albumList3.add(alb5);
            List<Album> albumList4 = new ArrayList<>();albumList4.add(alb1);albumList4.add(alb7);

            var playlists = new PlaylistDAO();
            Playlist p1 = new Playlist(1, "P no1", "07/05/2023");
            Playlist p2 = new Playlist(2, "P no2", "16/06/2002");
            Playlist p3 = new Playlist(3, "P no3", "01/01/1999");
            Playlist p4 = new Playlist(4, "P no4", "20/11/2001");
            p1.setAlbums(albumList1);
            p2.setAlbums(albumList2);
            p3.setAlbums(albumList3);
            p4.setAlbums(albumList4);
            playlists.create(p1);
            playlists.create(p2);
            playlists.create(p3);
            playlists.create(p4);
            Database.getConnection().commit();
            playlists.maxPlaylists();
//            System.out.println("Finding albums related to: ");
//            System.out.println("~First album: " + playlists.findRelatedAlbums(alb1));
//            System.out.println("~6th album: " + playlists.findRelatedAlbums(alb6));
//            System.out.println("~7th album: " + playlists.findRelatedAlbums(alb7));

            //print all the albums in the database
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM albums");
            while (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String genre = rs.getString("genre");
                System.out.println(id + "\t" + releaseYear + "\t" + title + "\t" + artist + "\t" + genre);
            }
            rs.close();
            stmt.close();
            con.close();

            /* ------------ importing data from a real dataset
            String line = "";
            String delimiter = ",";
            int id = 2;
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("albumlist.csv"));
                br.readLine(); // skip headers
                while ((line = br.readLine()) != null && id <= 15)
                {   id = id + 1;
                    String[] albumData = line.split(delimiter);
                    int year = Integer.parseInt(albumData[1]);
                    String title = albumData[2];
                    String artist = albumData[3];
                    String genre = albumData[4];
                    Album album = new Album(id, year, title, artist, genre);
                    System.out.println(album);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            } */

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}