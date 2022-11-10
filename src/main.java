import java.util.ArrayList;
import java.io.*;
import java.lang.Math;
import java.util.*;

public class main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<song> rank = new ArrayList();
    static ArrayList<song> fav = new ArrayList();
    static ArrayList<Double> sums = new ArrayList();

    static boolean ask = true;
    static boolean quit = false;

    static int count = 0;
    static int start;

    static double counter = 0;
    static double highest = 0;
    static double sum = 0;
    static double average = 0;
        
    static String favArtist = "";

    public static void main(String[] args) throws IOException{
        while (quit == false){
            NAV();
            songInputs();
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
                rankList songRank = new rankList();
                songRank.addSong();
            }
            }
    }
    public static void stats()throws IOException{
        if (start == 4){
            System.out.println("");
            System.out.println("Songs ranked from highest to lowest ");
            for (int i = 100; i >= 0; i--){
                for (int t = 0; t < rank.size(); t++){
                    song now = rank.get(t);
                    if (now.getRating()*10 == i){
                        count++;

                        System.out.println(count + ". " + now.getName() + ", by: " + now.getArtist()+ ", " + now.getRating()); 
                    }
                }
            }
            counter = 0;
            sum = 0;
            System.out.println("");
            for (int i = 0; i < fav.size(); i++){
                song now = fav.get(i);
                for (int x = 0; x < fav.size(); x++){
                    song look = fav.get(x);
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
            backToNAV();
        }
    }
}