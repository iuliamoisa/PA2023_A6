package org.example.objectModel;

import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private String creationTimestamp;
    private List<Album> albums;
    public Playlist (int id, String name, String time){
        this.name = name;
        this.creationTimestamp = time;
        this.id = id;
    }

    public void addAlbumToList(Album album, List<Album> albumList) {
        albumList.add(album);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
