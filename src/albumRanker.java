import java.util.ArrayList;

public class albumRanker {

    public static ArrayList<album> albumRank;

    public static double sum = 0;
    public static double average = 0;
    public static double highest = 0;

    public static album favAlbum;
    
    public albumRanker(){
        albumRank = new ArrayList<album>();
    }

    public void addAlbum(album album){
        albumRank.add(album);
    }

    public void albumInfo(){
        for (int i = 0; i < albumRank.size(); i++){
            album now = albumRank.get(i);
            System.out.println("");
            System.out.print(now.getName() + " by: " + now.getArtist());

            for (int w = 0; w < now.getSize(); w++){
                song songNow = now.getTheSong(w);
                sum = sum + songNow.getSongRating();
            }


            if (sum / now.getSize() > highest){
                highest = sum / now.getSize();
                favAlbum = now;
            }

            System.out.println(", Average Rating: " + (sum / now.getSize()));
            sum = 0;

            
            for (int y = 100; y >= 0; y--){
                for (int x = 0; x < now.getSize(); x++){
                    song songNow = now.getTheSong(x);
                    if (songNow.getSongRating()*10 == y){
                        System.out.println(songNow.getName() + " " + songNow.getSongRating());
                    }
                }
            }
        }
}

    public void favAlbum(){
        System.out.println("");
        System.out.println("Favorite album " + favAlbum.getName() + ", by: " + favAlbum.getArtist() + ", average score: " + highest);
    }



}
