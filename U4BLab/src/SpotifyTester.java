

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class SpotifyTester {
    public static void main(String[] args) throws FileNotFoundException {
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


}




