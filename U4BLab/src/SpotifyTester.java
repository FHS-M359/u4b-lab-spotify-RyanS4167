import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SpotifyTester {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        Playlist playlist = new Playlist();
        playlist.readSongData("spotify_unique_years_artists.txt");
        while(choice != 7){
            System.out.println("===== Spotify Menu =====");
            System.out.println(1 + " - Sort by artist(A-Z)");
            System.out.println(2 + " - Sort by Artist(Z-A)");
            System.out.println(3 + " - Sort by year(oldest - newest)");
            System.out.println(4 + " - Sort by year(newest - oldest)");
            System.out.println(5 + " - Search by Genre");
            System.out.println(6 + " - Display all songs");
            System.out.println(7 + " - Quit");
            System.out.println("Choose an option: ");
            choice = getValidOption(scan);
            if(choice ==1) {
                playlist.sortByAZ();
                System.out.print(playlist);
            }
            if(choice == 2){
                playlist.sortByZA();
                System.out.println(playlist);
            }
            if(choice == 3) {
                playlist.sortByOldToNew();
                System.out.println(playlist);
            }
            if(choice == 4){
                playlist.sortByNewToOld();
                System.out.println(playlist);
            }
            if (choice == 5) {
                System.out.println("Enter Genre :");
                String genre = scan.next();
                playlist.searchByGenre(genre);
            }
            if(choice == 7){
                System.out.println("Bye have a good one!");
                scan.close();
            }
        }
    }

    public static int getValidOption(Scanner scan){
        int choice = 0;
        while(true){
            try{
                choice = scan.nextInt();
                if(choice >= 1 && choice <=7){
                    return choice;
                }
                else {
                    System.out.println("Enter a number 1-7");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter only numbers 1-7");
                scan.next();
            }
        }
    }
}






