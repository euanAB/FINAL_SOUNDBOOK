
import java.text.DecimalFormat;

public class Song {

    private final int ID;
    private String title;
    private String artistName;
    private long playCount;
    private static final DecimalFormat df = new DecimalFormat("###,###,###");

    //constructor for comparing purpose in arraylist to remove/search for songs
    public Song(int ID) {
        this.ID = ID;
    }

    //initialize song
    public Song(int ID, String title, String artistName, long playCount) {
        this.ID = ID;
        this.title = title;
        this.artistName = artistName;
        this.playCount = playCount;
    }

    //return song id
    public int getID() {
        return ID;
    }

    //return title of song
    public String getTitle() {
        return title;
    }

    //change song title
    public void setTitle(String title) {
        this.title = title;
    }

    //return song's artist name
    public String getArtistName() {
        return artistName;
    }

    //change song's artist name
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    //return number of times song played
    public long getPlayCount() {
        return playCount;
    }

    //change number of times song played
    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    //compare two songs using id only
    public boolean equals(Object obj) {
        Song song = (Song) obj;
        return ID == song.ID;
    }

    //return string representation of song
    public String toString() {
        return String.format("%-15d%-20s%-30s%s",
                ID, title, artistName, df.format(playCount));
    }

}

