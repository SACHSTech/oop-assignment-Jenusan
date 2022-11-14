import java.util.ArrayList;

public class album extends rating{
    public String name;
    public String artist;
    public ArrayList<song> theSongList;
    public int songNums;

    public song songNow;

    public album(String name, String artist, ArrayList<song> songList, int songNums){
        super(rating);
        this.name = name;
        this.artist = artist;
        theSongList = songList;
        this.songNums = songNums;
    }

    public String getName(){
        return this.name;
    }

    public song getTheSong(int i){
        return (theSongList).get(i);
    }

    public int getNumberSongs(){
        return this.songNums;
    }

    public String getArtist(){
        return this.artist;
    }

    public int getSize(){
        return (theSongList).size();
    }

    public String getSong(int i){
        songNow = theSongList.get(i);
        return songNow.getName();
        
    }

    public double getRating(int i){
        songNow = theSongList.get(i);
        return songNow.getSongRating();
    }
}
