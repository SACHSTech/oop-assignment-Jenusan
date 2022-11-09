import java.util.ArrayList;
import java.io.*;
import java.lang.Math;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<song> rank = new ArrayList();
        ArrayList<song> fav = new ArrayList();
        ArrayList<Double> sums = new ArrayList();
        boolean ask = true;
        boolean quit = false;
        int count = 0;
        double counter = 0;
        double highest = 0;
        double sum = 0;
        double average = 0;
        String favArtist = "";

        while (quit == false){
        System.out.println("");
        System.out.println("Press 0 to quit");
        System.out.println("Press keys 1-4 to navigate");
        System.out.println("Rate Songs   (1) ");
        System.out.println("Beta testing (2) ");
        System.out.println("Stats        (4) ");
        int start = Integer.parseInt(key.readLine());
        if (start == 0){
            quit = true;
        }

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
        }
        }

        if (start == 2){
            counter = 0;
            sum = 0;
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
            start = 0;
        }
        
        if (start == 4){
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Songs ranked from highest to lowest ");
            for (int i = 100; i >= 0; i--){
                for (int t = 0; t < rank.size(); t++){
                    song now = rank.get(t);
                    if (now.getRating()*10 == i){
                        count++;

                        System.out.println(count + ". " + now.getName() + ", " + now.getArtist()+ ", " + now.getRating()); 
                    }
                }
            }
            System.out.println("");
            System.out.println("");
            start = 0;
        }

        }

    }
}
