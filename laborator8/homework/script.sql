create database albums;
use albums;

CREATE TABLE artists (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE albums (
  id INT NOT NULL AUTO_INCREMENT,
  release_year INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  artist VARCHAR(255) NOT NULL,
  genre VARCHAR(255),
  PRIMARY KEY (id)
);
CREATE TABLE genres (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE album_genres (
  id INT NOT NULL AUTO_INCREMENT,
  album_id INT NOT NULL,
  genre_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (album_id) REFERENCES albums(id),
  FOREIGN KEY (genre_id) REFERENCES genres(id)
);