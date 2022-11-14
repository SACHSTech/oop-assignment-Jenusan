import java.util.ArrayList;

public class album extends rating{
    public String name;
    public String artist;
    public ArrayList<song> theSongList;

    public song songNow;

    public album(String name, String artist, ArrayList<song> songList){
        super(rating);
        this.name = name;
        this.artist = artist;
        theSongList = songList;
    }

    public String getName(){
        return this.name;
    }

    public song getTheSong(int i){
        return (theSongList).get(i);
    }

    public String getArtist(){
        return this.artist;
    }

    public int getSize(){
        return (theSongList).size();
    }
}
