import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Playlist {
    private ArrayList<Song> songs;
    public Playlist(){
        songs = new ArrayList<>();
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }
    public String toString() {
        String result = String.format("%-20s %-18s %-19s %-8s %-12s%n", "Title",
                "Artist", "Album", "Year", "Genre");
        result += "---------------------------------------------------------------------------------------------\n";
        for (Song s : songs) {
            result += s;
        }
        return result;
    }
    public static void searchByGenre(){

    }

}


