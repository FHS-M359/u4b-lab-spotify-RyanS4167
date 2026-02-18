import java.util.Scanner;


public class SpotifyTester {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        Playlist playlist = new Playlist();
        playlist.readSongs("spotify_unique_years_artists.txt");


        int choice = 0;


        while (choice != 7) {


            printMenu();
            choice = getValidChoice(input);


            if (choice == 1) {
                playlist.sortByArtist(true);
                System.out.println(playlist);
            }
            else if (choice == 2) {
                playlist.sortByArtist(false);
                System.out.println(playlist);
            }
            else if (choice == 3) {
                playlist.sortByReleaseYear(true);
                System.out.println(playlist);
            }
            else if (choice == 4) {
                playlist.sortByReleaseYear(false);
                System.out.println(playlist);
            }
            else if (choice == 5) {
                System.out.print("Enter genre: ");
                String genre = input.next();
                playlist.searchByGenre(genre);
            }
            else if (choice == 6) {
                System.out.println(playlist);
            }
        }


        input.close();
    }


    public static void printMenu() {
        System.out.println("\n--- Spotify Menu ---");
        System.out.println("1. Sort Artist A-Z");
        System.out.println("2. Sort Artist Z-A");
        System.out.println("3. Sort Release Year Old-New");
        System.out.println("4. Sort Release Year New-Old");
        System.out.println("5. Search by Genre");
        System.out.println("6. Display All Songs");
        System.out.println("7. Quit");
        System.out.print("Choose an option: ");
    }


    public static int getValidChoice(Scanner input) {
        int choice = -1;
        while (true) {
            try {
                choice = Integer.parseInt(input.next());


                if (choice >= 1 && choice <= 7) {
                    return choice;
                } else {
                    System.out.print("Enter a number 1-7: ");
                }


            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number 1-7: ");
            }
        }
    }
}



