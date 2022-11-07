
import java.net.IDN;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SoundBook {

    //add new song, if song id is repeated don't add it
    public static void addSong(ArrayList<Song> songs, Scanner in) {
        System.out.print("Enter song ID: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.print("Enter song title: ");
        String name = in.nextLine();
        System.out.print("Enter artist name: ");
        String artistName = in.nextLine();
        System.out.print("Enter number of song plays: ");
        long plays = in.nextLong();
        //create new song
        Song song = new Song(id, name, artistName, plays);
        //if song with same id exist return otherwise add song
        if (songs.contains(song)) {
            System.out.println("You can't add song, ID: " + id + " exists. Please try again!");
        } else {
            songs.add(song);
            System.out.println("Song added successfully.");
        }
    }

    //remove a song using id
    public static void removeSong(ArrayList<Song> songs, Scanner in) {
        System.out.print("Enter song ID to be removed: ");
        int id = in.nextInt();
        int index = songs.indexOf(new Song(id));
        //if song id found
        if (index != -1) {
            Song song = songs.remove(index);
            System.out.println("The song " + song.getTitle() + " By "
                    + song.getArtistName() + " has been removed.");
        } //if not found
        else
            System.out.println("Error: Song ID not found.");
    }

    //print all songs
    public static void printAllSongs(ArrayList<Song> songs) {
        System.out.println("List Of Songs stored on SoundBook:");
        System.out.printf("%-15s%-20s%-30s%s\n", "ID", "Title", "Artist Name", "Plays Count");
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    //print all artists
    public static void printAllArtists(ArrayList<Song> songs) {
        System.out.println("List of Artists stored on SoundBook:");
        for (Song song : songs) {
            System.out.println(song.getArtistName());
        }
    }

    //print top songs with over 500,000,000 plays sorted
    public static void printTopSongs(ArrayList<Song> songs) {
        //sort by plays count in descending order
        Collections.sort(songs, (a, b)
                -> Long.compare(b.getPlayCount(), a.getPlayCount()));
        //print top songs
        System.out.println("List of Songs with over 500,000,000 listens:");
        System.out.printf("%-15s%-20s%-30s%s\n", "ID", "Title", "Artist Name", "Plays Count");
        for (Song song : songs) {
            if (song.getPlayCount() > 500000000)
                System.out.println(song);
        }
    }

    //display the menu for user
    public static void printMenu() {
        System.out.println("\n=========================================");
        System.out.println("To begin, please enter a valid choice from menu:");
        System.out.println("1. Add new song");
        System.out.println("2. Remove a song");
        System.out.println("3. Print all songs");
        System.out.println("4. Print all artists");
        System.out.println("5. Print top songs");
        System.out.println("6. Exit");
        System.out.print(">> ");
    }

    public static void main(String[] args) {
        System.out.println("Hello, welcome to SoundBook! The top music platform");
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Enemy", "The Weeknd", 100000));
        songs.add(new Song(2, "Cooler Than Me", "Mike Posner", 9924424));
        songs.add(new Song(3, "Hotel", "Lawsy", 33489928));
        songs.add(new Song(4, "No Role modelz", "J.Cole", 8935553));
        songs.add(new Song(5, "Same Girl", "R.Kelly + Usher", 1000));
        songs.add(new Song(6, "Lonely", "AKON", 1001));
        songs.add(new Song(6, "Pon De Replay", "Rihanna", 1002));
        songs.add(new Song(7, "Home Pussy", "D-Block", 1003));
        songs.add(new Song(8, "Trippie Redd", "Partynextdoor", 1004));
        songs.add(new Song(9, "True Colours", "The Weeknd", 1005));
        songs.add(new Song(10, "Windsor House", "AB", 1006));
        songs.add(new Song(11, "Oh Nah", "Wiz Khalifa", 1007));
        songs.add(new Song(12, "Ma Colombe", "Nej", 1008));
        songs.add(new Song(13, "On My Mind", "Georgia Smith", 1009));
        songs.add(new Song(14, "Girls born in the 90's", "The Weeknd", 9000));
        songs.add(new Song(15, "Slow Motion", "Trey", 9001));
        songs.add(new Song(16, "Call Out My Name", "The Weeknd", 9002));
        songs.add(new Song(17, "Love Nwantiti", "DJ Yo", 9003));
        songs.add(new Song(18, "At least we tried", "Giveon", 9004));
        songs.add(new Song(19, "White Tee", "Marzipan", 9005));
        songs.add(new Song(20, "Interlude", "The Weeknd", 9006));
        songs.add(new Song(21, "Oh Nah", "Wiz Khalifa", 500000000));
        Scanner in = new Scanner(System.in);
        printMenu();
        int choice = in.nextInt();
        while (choice != 6) {
            switch (choice) {
                case 1: // add new song
                    addSong(songs, in);
                    break;
                case 2: // remove song
                    removeSong(songs, in);
                    break;
                case 3: // print songs
                    printAllSongs(songs);
                    break;
                case 4: // print artists
                    printAllArtists(songs);
                    break;
                case 5: // print top songs
                    printTopSongs(songs);
                    break;
                case 6: // exit
                    break;
                default: // invalid
                    System.out.println("Oops! Please choose a valid option...");
            }
            printMenu();
            choice = in.nextInt();
        }
        in.close();
    }
}

