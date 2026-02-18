import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Playlist {


    private ArrayList<Song> songs;


    public Playlist() {
        songs = new ArrayList<Song>();
    }


    public void readSongs(String filename) {


        try {
            Scanner fileScan = new Scanner(new File("spotify_unique_years_artists.txt"));
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String[] parts = line.split(",");


                String title = parts[0];
                String artist = parts[1];
                String album = parts[2];
                int year = Integer.parseInt(parts[4]);
                String genre = parts[5];


                Song s = new Song(title, artist, album, year, genre);
                songs.add(s);
            }


            fileScan.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public void searchByGenre(String genre) {


        boolean found = false;


        for (Song s : songs) {
            if (s.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(s);
                found = true;
            }
        }


        if (!found) {
            System.out.println("No songs found in that genre.");
        }
    }


    public void sortByArtist(boolean ascending) {


        for (int i = 0; i < songs.size() - 1; i++) {


            int index = i;


            for (int j = i + 1; j < songs.size(); j++) {


                int compare = songs.get(j).getArtist()
                        .compareToIgnoreCase(songs.get(index).getArtist());


                if (ascending) {
                    if (compare < 0)
                        index = j;
                } else {
                    if (compare > 0)
                        index = j;
                }
            }


            Song temp = songs.get(i);
            songs.set(i, songs.get(index));
            songs.set(index, temp);
        }
    }


    public void sortByReleaseYear(boolean ascending) {


        for (int i = 1; i < songs.size(); i++) {


            Song key = songs.get(i);
            int j = i - 1;


            while (j >= 0 &&
                    (ascending
                            ? songs.get(j).getReleaseYear() > key.getReleaseYear()
                            : songs.get(j).getReleaseYear() < key.getReleaseYear())) {


                songs.set(j + 1, songs.get(j));
                j--;
            }


            songs.set(j + 1, key);
        }
    }


    public String toString() {


        String result = String.format("%-15s %-13s %-15s %-10s %-15s\n",
                "Title", "Artist", "Album", "Year", "Genre");


        result += "---------------------------------------------------------------------------------------------\n";


        for (Song s : songs) {
            result += s;
        }


        return result;
    }
}


