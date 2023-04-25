package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            Database.deleteAll("albums");
            Database.deleteAll("artists");
            var artists1 = new ArtistDAO();
            artists1.create("Pink Floyd");
            var artists2 = new ArtistDAO();
            artists2.create("Michael Jackson");
            Database.getConnection().commit();
            System.out.println(artists1.findByName("Michael Jackson"));


//            var genres = new GenreDAO();
//            genres.create("Rock"); //TODO: Funk, Soul, Pop
//            Database.getConnection().commit();

//            var albums = new AlbumDAO();
//            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
//            //findByName
//            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
//                    Database.getConnection().commit();
//            // TODO: print all the albums in the database
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            //Database.rollback();
        }
    }
}