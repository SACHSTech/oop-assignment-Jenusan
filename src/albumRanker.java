import java.util.ArrayList;

public class albumRanker {

    public static ArrayList<album> albumRank;
    public static ArrayList<song> SongsInAlbum;
    public static ArrayList<ArrayList> songsPerAlbum;
    
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
            System.out.println("");
            System.out.println(now.getName() + " by: " + now.getArtist());

            for (int y = 100; y >= 0; y--){
                for (int x = 0; x < now.getNumberSongs(); x++){
                    if (now.getRating(x)*10 == y){
                        System.out.println(now.getSong(x) + " " + now.getRating(x));
                    }
                }
            }
        }
}
}
