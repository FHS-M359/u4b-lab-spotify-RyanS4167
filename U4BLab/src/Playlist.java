import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Playlist {
    private static ArrayList<Song> songs;

    /**
     * Constructor to be used in SpotifyTester Class
     */
    public Playlist(){
        songs = new ArrayList<>();
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * String format to space the titles for sections correctly in a uniform way
     * @return
     */
    public String toString() {
        String result = String.format("%-22s %-20s %-28s %-6s %-12s", "Title",
                "Artist", "Album", "Year", "Genre");
        result += "\n---------------------------------------------------------------------------------------------------\n";
        for (Song s : songs) {
            result += s;
        }
        return result;
    }

    /**
     *Will scan the data of the file being read, and then
     * put the data into a song ArrayList
     * @param filename
     */
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


    /**
     * Linear search method
     * Takes in the parameter typed in
     * Scans for any genre matching from the parameter and the txt file
     * Prints the song if the variable genre from txt file matches the input
     * @param input
     */
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

    /**
     * Selection sort method
     * uses a for loop to go through all the rows of songs, albums, etc.
     * nested for loop also goes through the same as the one its in
     * Switches values so its song objects by increasing alphabetical order
     *
     */
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

    /**
     * Selection sort method
     *uses a for loop to go through all the rows of songs, albums, etc.
     * nested for loop also goes through the same as the one its in
     * Switches values so songs objects are decreasing alphabetical order
     */
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

    /**
     * Insertion sort method
     * Saves a year index,
     * Shifts larger elements to the right when inserting the smaller year
     *
     */
    public void sortByOldToNew(){
        for(int i =1; i<songs.size(); i++){
            Song tempVal = songs.get(i);
            int position = i;
            while(position>0 && songs.get(position-1).getReleaseYear() > tempVal.getReleaseYear()){
                songs.set(position, songs.get(position-1));
                position--;
            }
            songs.set(position, tempVal);
        }

    }

    /**Insertion sort method
     *Saves a year index each iteration
     * Shifts larger elements to the left when inserting the smaller year
     */
    public void sortByNewToOld(){
        for(int i =1; i<songs.size(); i++){
            Song tempVal = songs.get(i);
            int position = i;
            while(position>0 && songs.get(position-1).getReleaseYear() < tempVal.getReleaseYear()){
                songs.set(position, songs.get(position-1));
                position--;
            }
            songs.set(position, tempVal);
        }

    }

}





