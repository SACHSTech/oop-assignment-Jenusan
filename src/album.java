import java.util.ArrayList;

public class album extends rating{
    public String name;
    public ArrayList<song> theSongList;

    public song songNow;

    public album(String name, ArrayList<song> songList){
        super(rating);
        this.name = name;
        theSongList = songList;
    }

    public String getName(){
        return this.name;
    }

    public song getTheSong(int i){
        return (theSongList).get(i);
    }

    public String getArtist(int i){
        return (theSongList.get(i)).getArtist();
    }

    public int getSize(){
        return (theSongList).size();
    }
}
