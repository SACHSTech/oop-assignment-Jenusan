import java.util.ArrayList;
import java.io.*;

public class main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<song> rank = new ArrayList();
    static ArrayList<song> fav = new ArrayList();
    static ArrayList<song> songList = new ArrayList();
    static ArrayList<Double> sums = new ArrayList();

    public static album now;
    public static rankList songRanks;

    static boolean ask = true;
    static boolean quit = false;
    static boolean albumFiller = true;

    static int start;


    public static void main(String[] args) throws IOException{
        songRanks = new rankList();
        while (quit == false){
            NAV();
            songInputs();
            albumInputs();
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
        System.out.println("Stats         |(4) ");
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
                songRanks.addSong(s);
            }
            }
    }

    public static void albumInputs()throws IOException{
        if (start == 2){
            while (ask){
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
                    System.out.print("");
                System.out.println("input (0) to quit");
                System.out.print("enter song name: ");
                String name = input.readLine();
                if (name.equals("0")){
                    now = new album(album, artist, songList);
                    System.out.println(now.getName());
                    System.out.println(now.getArtist());
                    System.out.println(now.getSong());
                    System.out.println(now.getRating());
                    
                    break;
                }
                System.out.print("enter rating: ");
                double rate = Double.parseDouble(key.readLine());

                song songs = new song(name, rate, artist);
                songList.add(songs);
                }

            }
            }
    }



    public static void stats()throws IOException{
        if (start == 4){
            songRanks.ranketh();
            songRanks.fav();
            backToNAV();
        }
    }
}