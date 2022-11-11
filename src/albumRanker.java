import java.util.ArrayList;

public class albumRanker {

    public static ArrayList<album> albumRank;
    public static ArrayList<song> SongsInAlbum;
    public static ArrayList<ArrayList> songsPerAlbum;
    private int count = 0;
    
    public albumRanker(){
        albumRank = new ArrayList<album>();
        SongsInAlbum = new ArrayList<song>();
        songsPerAlbum = new ArrayList<ArrayList>();
    }

    public void addAlbum(album album){
        albumRank.add(album);
    }

    public void albumInfo(){
        for (int i = 0; i < albumRank.size(); i++){
            album now = albumRank.get(i);
            System.out.println(now.getName() + " by: " + now.getArtist());
            System.out.println(now.getNumberSongs());
            for (int x = 0; x < now.getNumberSongs(); x++){
                System.out.println(now.getSong(x));
                System.out.println(now.getRating(x));
            }
        }
}
}
