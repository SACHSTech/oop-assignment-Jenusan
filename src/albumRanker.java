import java.util.ArrayList;

public class albumRanker {

    public static ArrayList<album> albumRank;
    public static ArrayList<song> SongsInAlbum;

    public static int s;

    public static double sum = 0;
    public static double average = 0;

    public static int songCount = 0;
    
    public albumRanker(){
        albumRank = new ArrayList<album>();
        SongsInAlbum = new ArrayList<song>();
    }

    public void addAlbum(album album){
        albumRank.add(album);
    }

    public void songCount(){
        songCount++;
    }



    public void albumInfo(){
        for (int i = 0; i < albumRank.size(); i++){
            album now = albumRank.get(i);
            System.out.println("");
            System.out.print(now.getName() + " by: " + now.getArtist());

            for (int w = 0; w < now.getNumberSongs(); w++){
                song songNow = now.getTheSong(w);
                sum = sum + songNow.getSongRating();
            }
            System.out.println("Average Rating: " + (sum / now.getNumberSongs()));
            sum = 0;

            
            for (int y = 100; y >= 0; y--){
                for (int x = 0; x < now.getNumberSongs(); x++){
                    
                    song songNow = now.getTheSong(x);
                    if (songNow.getSongRating()*10 == y){
                        System.out.println(now.getSong(x) + " " + now.getRating(x));
                    }
                }
            }
        }
}
}
