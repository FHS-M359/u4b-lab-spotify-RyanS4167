import java.util.ArrayList;
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
        String result = String.format("%-20s %-20s %-19s %-8s %15s", "Title",
                "Artist", "Album", "Year", "Genre");
        result += "\n---------------------------------------------------------------------------------------------\n";
        for (Song s : songs) {
            result += s;
        }
        return result;
    }
    public void readSongData(String filename) {
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




    public void searchByGenre(String input){
        boolean found = false;
        for (Song s : songs){
            if(s.getGenre().equalsIgnoreCase(input) ){
                System.out.println(s);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No songs in this genre are found.");
        }
    }
    //Selection sort
    public void sortByAZ(){
        for (int i = 0; i<songs.size() -1; i++){
            int minIndex = i;
            for(int j = i+1; j<songs.size(); j++){
                int compare = songs.get(j).getArtist().compareToIgnoreCase(songs.get(minIndex).getArtist());
                if(compare<0){
                    minIndex = j;
                }
            }
            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }
    }
    public void sortByZA(){
        for (int i = 0; i<songs.size() -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < songs.size(); j++) {
                int compare = songs.get(j).getArtist().compareToIgnoreCase(songs.get(minIndex).getArtist());
                if (compare > 0) {
                    minIndex = j;
                }
            }


            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }


    }
}





