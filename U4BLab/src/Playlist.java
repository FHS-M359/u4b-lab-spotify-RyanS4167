import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Playlist {
    private static ArrayList<Song> songs;
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
    public static void readSongData() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("spotify_unique_years_artists.txt"));
        ArrayList<Song> song = new ArrayList<Song>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] parts = line.split(",");
            String title = parts[0];
            String artist = parts[1];
            String album = parts[2];
            int year = Integer.parseInt(parts[4]);
            String genre = parts[5];
            Song songs = new Song(title, artist, album, year, genre);
            song.add(songs);
        }
        scan.close();
        Song.printInfo(song);
    }
    public static void searchByGenre(String input){
        boolean found = false;
        for (Song s : songs){
            if(s.getGenre().equalsIgnoreCase(input) ){
                System.out.println(s);
                found = true;
            }
            else {
                System.out.println("No songs in this genre are found.");
            }
        }
    }
    public static void sortByAZ(){
        
    }

}


