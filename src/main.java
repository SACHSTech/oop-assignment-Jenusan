import java.util.ArrayList;
import java.io.*;

public class main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<song> rank = new ArrayList<song>();
    static ArrayList<song> fav = new ArrayList<song>();
    public static ArrayList<ArrayList<song>> List = new ArrayList<ArrayList<song>>();
    static ArrayList<Double> sums = new ArrayList<Double>();

    public static album now;
    public static songRanker songRanks;
    public static albumRanker albumStats;

    static boolean ask = true;
    static boolean quit = false;
    static boolean albumFiller = true;

    static int start;
    public static int songCounter;


    public static void main(String[] args) throws IOException{
        songRanks = new songRanker();
        albumStats = new albumRanker();
        while (quit == false){
            NAV();
            songInputs();
            albumInputs();
            albumStats();
            stats();
        }
    }

    public static void backToNAV() throws IOException{
        System.out.println("");
        System.out.println("press any key to return to NAV");
        String next = input.readLine();

        if (next == ""){
            start = 0;
        }else{
            start = 0;
        }
    }

    public static void NAV()throws IOException{
        System.out.println("");
        System.out.println("Press 0 to quit");
        System.out.println("Press keys 1-4 to navigate");
        System.out.println("Rate Songs    |(1) ");
        System.out.println("Rate Albums   |(2) ");
        System.out.println("Song stats    |(3) ");
        System.out.println("Album stats   |(4) ");
        start = Integer.parseInt(key.readLine());
        if (start == 0){
            quit = true;
        }
    }
    public static void songInputs()throws IOException{
        if (start == 1){
            while (ask){
                System.out.println("");
                System.out.println("input (0) to quit");
                System.out.print("enter song name: ");
                String song = input.readLine();
                if (song.equals("0")){
                    start = 0;
                    break;
                }
                System.out.print("enter artist name: ");
                String artist = input.readLine();
                System.out.print("enter rating: ");
                double rate = Double.parseDouble(key.readLine());
    
                song s = new song(song, rate, artist);
                rank.add(s);
                fav.add(s);
                songRanks.addeth(s);
            }
            }
    }

    public static void albumInputs()throws IOException{
        if (start == 2){
            while (ask){
                ArrayList<song> songList = new ArrayList<song>();
                System.out.println("");
                System.out.println("input (0) to quit");
                System.out.print("enter album name: ");
                String album = input.readLine();
                if (album.equals("0")){
                    break;
                }
                System.out.print("enter artist name: ");
                String artist = input.readLine();

                while (albumFiller){
                System.out.println("");
                System.out.println("input (0) to quit");
                System.out.print("enter song name: ");
                String name = input.readLine();
                if (name.equals("0")){
                    now = new album(album, artist, songList, songCounter);
                    albumStats.addAlbum(now);
                    songCounter = 0;
                    //songList.removeAll(songList);
                    break;
                }
                System.out.print("enter rating: ");
                double rate = Double.parseDouble(key.readLine());

                song songs = new song(name, rate, artist);
                songList.add(songs);
                songCounter++;
                }
                
            }
            }
    }

    public static void stats()throws IOException{
        if (start == 3){
            songRanks.ranketh();
            songRanks.fav();
            backToNAV();
        }
    }

    public static void albumStats()throws IOException{
        if (start ==4){
            albumStats.albumInfo();
        }
    }
}