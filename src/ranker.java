import java.util.ArrayList;

public abstract class ranker{

    public static ArrayList<song> songRank;
    public static ArrayList<album> albumRank;

    public ranker(){
        songRank = new ArrayList<song>();
        albumRank = new ArrayList<album>();
    }

    public abstract void addeth();



}
