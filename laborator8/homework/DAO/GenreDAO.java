package org.example.DAO;

import org.example.connection.Database;
import org.example.objectModel.Artist;
import org.example.objectModel.Genre;

import java.sql.*;

public class GenreDAO {
    public void create(Genre genre) throws SQLException {
        int id = genre.getId();
        String name = genre.getName();
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id, name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }
    public Genre findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where name='" + name + "'")) {
            Genre genre = null;
            if(rs.next())
                genre = new Genre(rs.getInt("id"), rs.getString("name"));
            return genre;
            //return rs.next() ? rs.getInt(1) : null;
        }
    }
    public Genre findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where id='" + id + "'")) {
            Genre genre = null;
            if(rs.next())
                genre = new Genre(rs.getInt("id"), rs.getString("name"));
            return genre;
            //return String.valueOf(rs.next() ? rs.getInt(1) : null);
        }
    }
}
