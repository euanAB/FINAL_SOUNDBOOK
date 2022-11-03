
import java.util.*;

public class Program {

  static LinkedList<String> artists = new LinkedList<>();
  static String[][] songs = new String[2][3];

  public static void main(String[] args) 
  {

    System.out.println("***************" );
    System.out.println("SoundBox" );  
    System.out.println("    By Euan McGinness" );    
    System.out.println("****************" );
    MainApp();

  }

  public static int MainApp(){
    System.out.flush();  
    System.out.println("****************");

    int choice = MenuChoices();

    switch(choice){
        case 1: newArtist(); break;
        case 2: newSong(); break;
        case 3: removeSong(); break;
        case 4: upadteListCount(); break;
        case 5: artists(); break;
        case 6: allSongs(); break;
        case 7: topSongs(); break;
    }
    return choice;
  }
  public static int MenuChoices(){

    System.out.println("Menu");
    System.out.println("***************" + '\n');
    System.out.println("1. Add a new Artist");
    System.out.println("2. Add a new Song");
    System.out.println("3. Remove a song");
    System.out.println("4. Update listens count" );    
    System.out.println("5. Dispaly Stored Artists" );
    System.out.println("6. Dispaly All Songs");
    System.out.println("7. Dispaly Top Songs" + '\n');

    
    Scanner listner = new Scanner(System.in );    
    System.out.println("Write your option: ");
    int choice = Integer.parseInt(listner.nextLine()); 

    return choice;
  }
  public static void newArtist(){    
    System.out.println("ADD NEW ARTIST");
    System.out.println("***************" + '\n');
    System.out.println("Artist Name: ");
    
    Scanner listner = new Scanner(System.in ); 
    artists.push( listner.nextLine()); 
    MainApp();
  }

  public static void artists(){    
    System.out.println("All Artists: ");
    System.out.println("***************" + '\n');
    for (int i = 0; i < artists.size(); i++) {
        System.out.printf("%d %s \n",  i+1, artists.get(i) );
        
    System.out.println();
    }
    
    MainApp();
  }


  public static void newSong(){
    System.out.println("ADD NEW SONGS");
    System.out.println("***************" + '\n');

    int ind = 0;
    for (int i = 0; i < songs.length; i++) {
        if(songs[i][0] == null){
            ind = i;
        }
    }

    Scanner listner = new Scanner(System.in ); 

    System.out.println("Song Name: ");
    songs[ind][0] = listner.nextLine();
    System.out.println("Song Plays: ");        
    songs[ind][1] = listner.nextLine();
    
    System.out.println();

    MainApp();
  }

  public static void topSongs(){
    
    System.out.println("Top Songs:");
    System.out.println("***************" + '\n');
    int count = 0;
    for (int i = 0; i < songs.length; i++) {
        if( Integer.parseInt(songs[i][1]) > 999){ 
                count = count + 1;
                System.out.printf("%d Song Name: %s - Plays Count: %s",  count, songs[i][0], songs[i][1] );
    
    System.out.println();
            
        }
    }

    MainApp();

  }
  public static void allSongs(){
    
    System.out.println("All Songs:");
    System.out.println("***************" + '\n');

    int count = 0;
    for (int i = 0; i < songs.length; i++) {
            if(songs[i][0] != null){
                count = count + 1;
                System.out.printf("%d Song Name:  %s - Plays Count: %s",  count, songs[i][0], songs[i][1] );
            }
    System.out.println();
    }
    MainApp();
  }



  public static void removeSong(){    
    System.out.println("REMOVE SONG");
    System.out.println("***************" + '\n');


    System.out.println("Enter Song to remove:");
    Scanner listner = new Scanner(System.in ); 

    String songToRemove = listner.nextLine();
    for (int i = 0; i < songs.length; i++) {              
        if(songs[i][0] == songToRemove){
            songs[i][0] = null;
            songs[i][1] = null;
        }
    }


    MainApp();
  }
  public static void upadteListCount(){    
    System.out.println("UPDATE PLAYS COUNT");
    System.out.println("***************" + '\n');
    
    Scanner listner = new Scanner(System.in ); 

    String songToUpdate = listner.nextLine();
    
    for (int i = 0; i < songs.length; i++) {
                  
        if(songs[i][0] == songToUpdate){
            
            System.out.println("Enter PLAYS COUNT");
            
            songs[i][1] = listner.nextLine();
        }
    }
    MainApp();
  }

}


