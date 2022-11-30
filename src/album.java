import java.util.ArrayList;

public class Album extends Rating{

    // initializing variables
    private String name;
    private ArrayList<Song> theSongList;

    /**
     * 
     * @param name input for the name of the album
     * @param songList input for the arraylist of songs
     */
    public Album(String name, ArrayList<Song> songList){
        super(rating);
        this.name = name;
        theSongList = songList;
    }

    /**
     * method to get name
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     * @param i get index of which song to get
     * @return song
     */
    public Song getTheSong(int i){
        return (theSongList).get(i);
    }

    /**
     * 
     * @param i index 
     * @return sting
     */
    public String getArtist(int i){
        return (theSongList.get(i)).getArtist();
    }

    /**
     * 
     * @return size of songlist
     */
    public int getSize(){
        return (theSongList).size();
    }
}
