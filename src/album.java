import java.util.ArrayList;

public class album extends rating{
    private String name;
    private String artist;
    private ArrayList<song> songList;

    public int songCount = 0;
    public int ratingCount = 0;

    public album(String name, String artist, ArrayList<song> songList){
        super(rating);
        this.name = name;
        this.artist = artist;
        this.songList = songList;
    }

    public String getName(){
        return this.name;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getSong(){
        song now = songList.get(songCount);
        songCount++;
        return now.getName();
    }

    public double getRating(){
        song now = songList.get(ratingCount);
        ratingCount++;
        return now.getRating();
    }
}
