package org.example.DAO;

import org.example.connection.Database;
import org.example.objectModel.Artist;

import java.sql.*;

public class ArtistDAO {
    public void create(Artist artist) throws SQLException {
        int id = artist.getId();
        String name = artist.getName();
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (id, name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }
    public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where name='" + name + "'")) {
            Artist artist = null;
            if(rs.next())
                artist = new Artist(rs.getInt("id"), rs.getString("name"));
            return artist;
            // return rs.next() ? rs.getInt(1) : null;
        }
    }
    public Artist findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where id='" + id + "'")) {
            Artist artist = null;
            if(rs.next())
                artist = new Artist(rs.getInt("id"), rs.getString("name"));
            return artist;
            //return rs.next() ? rs.getString(1) : null;
        }
    }

}
