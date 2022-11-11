import java.util.ArrayList;

public class album extends rating{
    private String name;
    private String artist;
    private ArrayList<song> songList;
    private int songNums;

    public int songCount = 0;
    public int ratingCount = 0;

    public album(String name, String artist, ArrayList<song> songList, int songNums){
        super(rating);
        this.name = name;
        this.artist = artist;
        this.songList = songList;
        this.songNums = songNums;
    }

    public String getName(){
        return this.name;
    }

    public int getNumberSongs(){
        return this.songNums;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getSong(int i){
        song now = songList.get(i);
        return now.getName();
    }

    public double getRating(int i){
        song now = this.songList.get(i);
        return now.getRating();
    }
}
