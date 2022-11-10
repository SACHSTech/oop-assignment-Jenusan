import java.util.ArrayList;

public class rankList {

    int start;
    int count;
    int counter;
    int sum;
    int loopCount = 0;
    public static ArrayList<song> songRank;
    public static String favArtist;
    public double highest;
    public double average;

    public rankList(){
        songRank = new ArrayList();
    }

    public void addSong(song song){
        songRank.add(song);
    }

    public void ranketh(){
            System.out.println("");
            System.out.println("Songs ranked from highest to lowest ");
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

    public void fav(){
        System.out.println("");
            for (int i = 0; i < songRank.size(); i++){
                song now = songRank.get(i);
                for (int x = 0; x < songRank.size(); x++){
                    song look = songRank.get(x);
                    if((now.getArtist()).equals(look.getArtist())){
                        counter++;
                        sum += look.getRating();
                    }
                }
                average = sum/counter;
                if (average > highest){
                    highest = average;
                    favArtist = now.getArtist();
                }
                counter = 0;
                sum = 0;
            }
            System.out.println("your highest rated artist is " + favArtist + " with an average rating of " + highest);
    }
}
