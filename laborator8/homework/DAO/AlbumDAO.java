package org.example.DAO;

import org.example.connection.Database;
import org.example.objectModel.Album;
import org.example.objectModel.Artist;

import java.sql.*;

public class AlbumDAO {
    public void create(Album album) throws SQLException {
        int id = album.getId();
        int release_year = album.getRelease_year();
        String title = album.getTitle();
        String artist = album.getArtist();
        String genre = album.getGenre();
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, release_year, title, artist, genre) values (?,?,?,?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, release_year);
            pstmt.setString(3, title);
            pstmt.setString(4, artist);
            pstmt.setString(5, genre);
            pstmt.executeUpdate();
        }
    }
    public Album findByName(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where title='" + title + "'")) {
            Album album = null;
            if(rs.next())
                album = new Album(rs.getInt("id"), rs.getInt("release_year"), rs.getString("title"),rs.getString("artist"),rs.getString("genre"));
            return album;
        }
    }
    public Album findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where id ='" + id + "'")) {
            Album album = null;
            if(rs.next()) // release_year, String title, String artist, String genre
                album = new Album(rs.getInt("id"), rs.getInt("release_year"), rs.getString("title"),rs.getString("artist"),rs.getString("genre"));
            return album;
        }
    }
}
