import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;
    public Playlist(ArrayList<Song> songs){
        this.songs = songs;
    }
    public String toString(ArrayList<Song> rowSongs){
        return String.format("%-15s %-13s %-15s %-6s %5s%n", "Title", "Artist", "Album", "Year", "Genre");
    }
}
