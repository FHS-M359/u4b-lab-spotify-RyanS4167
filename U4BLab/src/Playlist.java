import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Playlist {
    private ArrayList<Song> songs;
    public Playlist(ArrayList<Song> songs){
        this.songs = songs;
    }
    public String toString(ArrayList<Song> rowSongs){
        return String.format("%-15s %-13s %-15s %-6s %5s%n", "Title", "Artist", "Album", "Year", "Genre");
    }
    public void readSongData(){
        try {
            Scanner fileScanner = new Scanner(new File("spotify_unique_years_artists.txt"));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                String title = parts[0].trim();
                String artist = parts[1].trim();
                String album = parts[2].trim();
                int duration = Integer.parseInt(parts[3].trim());
                int year = Integer.parseInt(parts[4].trim());
                String genre = parts[5].trim();

                songs.add(new Song(title, artist, album, duration, year, genre));
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
    public void searchDisplayByGenre(String genre){
        System.out.println("\nSongs in Genre: " + genre);
        for (Song song : songs) {
            if (song.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(song);
            }
        }
    }
    public void sortByArtist() {
        for (int i = 0; i < songs.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < songs.size(); j++) {
                if (songs.get(j).getArtist()
                        .compareToIgnoreCase(songs.get(minIndex).getArtist()) < 0) {
                    minIndex = j;
                }
            }

            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }
    }
    public void sortByReleaseYear() {
        for (int i = 1; i < songs.size(); i++) {
            Song key = songs.get(i);
            int j = i - 1;

            while (j >= 0 && songs.get(j).getReleaseYear() > key.getReleaseYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }
            songs.set(j + 1, key);
        }
    }
}
