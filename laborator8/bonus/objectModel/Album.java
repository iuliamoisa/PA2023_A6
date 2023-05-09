package org.example.objectModel;

public class Album {
    private int id;
    private int release_year;
    private String title;
    private String artist;
    private String genre;
    public Album (int id, int release_year, String title, String artist, String genre) {
        this.id = id;
        this.release_year = release_year;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }
    public Album(String title){
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album album)) return false;

        if (getId() != album.getId()) return false;
        if (getRelease_year() != album.getRelease_year()) return false;
        if (!getTitle().equals(album.getTitle())) return false;
        if (!getArtist().equals(album.getArtist())) return false;
        return getGenre() != null ? getGenre().equals(album.getGenre()) : album.getGenre() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getRelease_year();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getArtist().hashCode();
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", release_year=" + release_year +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}