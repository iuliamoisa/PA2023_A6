package org.example;

import org.example.DAO.AlbumDAO;
import org.example.DAO.ArtistDAO;
import org.example.DAO.GenreDAO;
import org.example.connection.Database;
import org.example.objectModel.Album;
import org.example.objectModel.Artist;
import org.example.objectModel.Genre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Database.deleteAll("albums");
            Database.deleteAll("artists");
            Database.deleteAll("genres");
            var artists = new ArtistDAO();
            Artist art1 = new Artist(1, "Pink Floyd");
            Artist art2 = new Artist(2, "Michael Jackson");
            artists.create(art1);
            artists.create(art2);
            Database.getConnection().commit();
            System.out.println("Trying to find Michael Jackson: " + artists.findByName("Michael Jackson"));
            var genres = new GenreDAO();
            var g1 = new Genre(1,"Rock");
            var g2 = new Genre(2,"Funk");
            var g3 = new Genre(3,"Soul");
            var g4 = new Genre(4,"Pop");
            genres.create(g1);
            genres.create(g2);
            genres.create(g3);
            genres.create(g4);
            System.out.println("The third genre: " + genres.findById(3));
            Database.getConnection().commit();

            var albums = new AlbumDAO();
            Album alb1 = new Album(1, 1979, "The Wall", "Pink Floyd", "Rock");
            Album alb2 = new Album(2, 1982, "Thriller", "Michael Jackson","Funk, Soul, Pop");
            albums.create(alb1);
            albums.create(alb2);
            System.out.println("Trying to find The Wall: " + albums.findByName("The Wall"));
            Database.getConnection().commit();

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

            // ------------ importing data from a real dataset
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
            }

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}