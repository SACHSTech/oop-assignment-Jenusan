import java.util.ArrayList;

public class rankList {

    int start;
    int count;
    int counter;
    int sum;
    int loopCount = 0;
    public static ArrayList<song> songRank;

    public rankList(){
        songRank = new ArrayList();
    }

    public void addSong(song song){
        songRank.add(song);
    }

    public void ranketh(){
            System.out.println("");
            System.out.println("Songs ranked from highest to lowest ");
            System.out.println(songRank.size());
            for (int i = 100; i >= 0; i--){
                for (int t = 0; t < songRank.size(); t++){
                    song now = songRank.get(t);
                    if (now.getRating()*10 == i){
                        count++;
                        System.out.println(count + ". " + now.getName() + ", by: " + now.getArtist()+ ", " + now.getRating()); 
                    }
                }
            }
            counter = 0;
            sum = 0;
    }
}
