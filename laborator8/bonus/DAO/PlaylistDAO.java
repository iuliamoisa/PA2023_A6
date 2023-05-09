package org.example.DAO;

import org.example.connection.Database;
import org.example.objectModel.Album;
import org.example.objectModel.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlaylistDAO {
    public void create(Playlist playlist) throws SQLException {
        int id = playlist.getId();
        String name = playlist.getName();
        String time = playlist.getCreationTimestamp();

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into playlists (id, name, timestamp) values (?,?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, time);
            pstmt.executeUpdate();
        }
        for (Album album : playlist.getAlbums()) {
            try (PreparedStatement pstmt2 = con.prepareStatement(
                    "insert into playlists_albums (playlist_id, album_id) values (?,?)")) {
                pstmt2.setInt(1, id);
                pstmt2.setInt(2, album.getId());
                pstmt2.executeUpdate();
            }
        }
    }

    public List<Album> findRelatedAlbums(Album album) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM albums " +
                             "WHERE id <> " + album.getId() + " " +
                             "AND (artist = '" + album.getArtist() + "' " +
                             "OR release_year = " + album.getRelease_year() + " " +
                             "OR genre IN (SELECT genre FROM albums WHERE id = " + album.getId() + "))")) {
            List<Album> relatedAlbums = new ArrayList<>();
            while (rs.next()) {
                Album relatedAlbum = new Album(rs.getInt("id"), rs.getInt("release_year"), rs.getString("title"),rs.getString("artist"),rs.getString("genre"));
                relatedAlbums.add(relatedAlbum);
            }
            return relatedAlbums;
        }
    }

    public void maxPlaylists(){
        List<String> artists = new ArrayList<>();
        List<String> genre = new ArrayList<>();
        List<Integer> year = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement playlist = con.createStatement();
             ResultSet resultPlaylist = playlist.executeQuery("select * from playlists");  ){
            while(resultPlaylist.next()){
                int id = resultPlaylist.getInt("id");
                try(Statement albums = con.createStatement();
                    ResultSet resultPlaylistsAlbums = albums.executeQuery("select * from playlists_albums")){
                    while(resultPlaylistsAlbums.next()){
                        int idPlaylist = resultPlaylistsAlbums.getInt("playlist_id");
                        if(idPlaylist == id) {
                            int idAlbum = resultPlaylistsAlbums.getInt("album_id");
                            try (PreparedStatement pstmt = con.prepareStatement(
                                    "SELECT * FROM albums WHERE id = ?")){
                                pstmt.setInt(1, idAlbum);
                                ResultSet rs = pstmt.executeQuery();
                                if (rs.next()) {
                                    artists.add(rs.getString("artist"));
                                    genre.add(rs.getString("genre"));
                                    year.add(rs.getInt("release_year"));
                                }
                             }
                        }
                    }
                }
                List<String>distArtists = artists.stream().distinct().collect(Collectors.toList());
                List<String>distGenres = genre.stream().distinct().collect(Collectors.toList());
                List<Integer>distYear = year.stream().distinct().collect(Collectors.toList());
                if(artists.size() == distArtists.size() && genre.size() == distGenres.size() && year.size() == distYear.size()){
                    System.out.println(resultPlaylist.getString("name"));
                }
                artists.clear();genre.clear();year.clear();
                distArtists.clear();distYear.clear();distYear.clear();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
