import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class Song {
    private String title, artist, album;
    private int durationSeconds;
    private int releaseYear;
    private String genre;
    public Song(String title, String artist, String album, int year, String genre){
        this.title = title;
        this.artist = artist;
        this.album = album;
        durationSeconds = 0;
        releaseYear = year;
        this.genre = genre;
    }




    public String getTitle() {
        return title;
    }




    public String getArtist() {
        return artist;
    }




    public String getAlbum() {
        return album;
    }




    public int getDurationSeconds() {
        return durationSeconds;
    }




    public int getReleaseYear() {
        return releaseYear;
    }




    public String getGenre() {
        return genre;
    }




    public void setTitle(String title) {
        this.title = title;
    }




    public void setArtist(String artist) {
        this.artist = artist;
    }




    public void setAlbum(String album) {
        this.album = album;
    }




    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }




    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String toString(){
        return String.format("%-20s %-16s %20s %20d %15s%n", title, artist, album, releaseYear, genre);
    }
}


