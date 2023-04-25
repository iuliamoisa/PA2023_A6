package org.example;

import java.sql.*;

public class AlbumDAO {
    public void create(Integer release_year, String name, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, name, artist, genre) values (?)")) {
            pstmt.setInt(1, release_year);
            pstmt.setString(2, name);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }

}
