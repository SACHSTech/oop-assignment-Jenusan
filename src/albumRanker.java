import java.util.ArrayList;

public class AlbumRanker{

    // intilizing variables
    private static ArrayList<Album> albumRank;

    private static double sum = 0;
    private static double average = 0;
    private static double highest = 0;

    private static Album favAlbum;
    
    // constructor
    public AlbumRanker(){
        albumRank = new ArrayList<Album>();
    }

    // adds album to global arraylist
    public void addAlbum(Album album){
        albumRank.add(album);
    }

    // gets numbers of albums
    public int getLength(){
        return albumRank.size();
    }

    // ranks and returns albums
    public void albumInfo(){
        for (int i = 0; i < albumRank.size(); i++){
            Album now = albumRank.get(i);
            System.out.println("");
            System.out.print(now.getName() + " by: " + now.getArtist(i));

            for (int w = 0; w < now.getSize(); w++){
                Song songNow = now.getTheSong(w);
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
                    Song songNow = now.getTheSong(x);
                    if (songNow.getSongRating()*10 == y){
                        System.out.println(songNow.getName() + " " + songNow.getSongRating());
                    }
                }
            }
        }
}

    // retursn fav album and its average score
    public void favAlbum(){
        System.out.println("");
        System.out.println("Favorite album " + favAlbum.getName() + ", by: " + favAlbum.getArtist(0) + ", average score: " + highest);
    }



}
