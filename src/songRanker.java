import java.util.ArrayList;

public class SongRanker{

    // initializes variables 
    int start;
    int count;
    int counter;
    int sum;

    private static ArrayList<Song> songRank;
    private static String favArtist;
    private double highest;
    private double average;

    // constructor
    public SongRanker(){
        songRank = new ArrayList<Song>();
    }

    // returns length of list 
    public int getLength(){
        return songRank.size();
    }

    // adds songs to global arraylist
    public void addeth(Song song){
        songRank.add(song);
    }

    // returns songs ranked
    public void ranketh(){
            System.out.println("");
            System.out.println("Songs ranked from highest to lowest ");
            for (int i = 100; i >= 0; i--){
                for (int t = 0; t < songRank.size(); t++){
                    Song now = songRank.get(t);
                    if (now.getSongRating()*10 == i){
                        count++;
                        System.out.println(count + ". " + now.getName() + ", by: " + now.getArtist()+ ", " + now.getSongRating()); 
                    }
                }
            }
    }

    // returns favorite artist
    public void fav(){
        System.out.println("");
            for (int i = 0; i < songRank.size(); i++){
                Song now = songRank.get(i);
                for (int x = 0; x < songRank.size(); x++){
                    Song look = songRank.get(x);
                    if((now.getArtist()).equals(look.getArtist())){
                        counter++;
                        sum += look.getSongRating();
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
