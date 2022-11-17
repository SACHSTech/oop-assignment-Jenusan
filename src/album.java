import java.util.ArrayList;

public class Album extends Rating{

    // initializing variables
    private String name;
    private ArrayList<Song> theSongList;

    // album constructor
    public Album(String name, ArrayList<Song> songList){
        super(rating);
        this.name = name;
        theSongList = songList;
    }

    //returns name of album
    public String getName(){
        return this.name;
    }

    // returns song object
    public Song getTheSong(int i){
        return (theSongList).get(i);
    }

    // returns artist
    public String getArtist(int i){
        return (theSongList.get(i)).getArtist();
    }

    // returns number of songs per album
    public int getSize(){
        return (theSongList).size();
    }
}
