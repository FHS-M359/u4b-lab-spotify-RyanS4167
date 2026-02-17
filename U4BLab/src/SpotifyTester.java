import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpotifyTester {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("spotify_unique_years_artists.txt"));
        ArrayList<Song> songs = new ArrayList<Song>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] info = line.split(",");
            String Title = info[0];
            String Artist = info[1];
            String Album = info[2];
            int year = Integer.parseInt(info[3]);
            String genre = info[4];
            Song information = new Song(Title, Artist, Album, year, genre);
            songs.add(information);
        }
        System.out.println(songs);

    }
}
