import java.util.ArrayList;
import java.io.*;

public class main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<song> List = new ArrayList();
        boolean ask = true;
        boolean quit = false;
        int count = 0;

        while (quit == false){
        System.out.println("Press 0 to quit");
        System.out.println("Press keys 1-4 to navigate");
        System.out.println("Rate Songs (1) ");
        System.out.println("Stats      (4) ");
        int start = Integer.parseInt(key.readLine());
        if (start == 0){
            quit = true;
        }

        if (start == 1){
        while (ask){
            System.out.print("input (0) to quit");
            System.out.print("enter song name: ");
            String song = input.readLine();
            if (song.equals("0")){
                start = 0;
                break;
            }
            System.out.print("enter artist name: ");
            String artist = input.readLine();
            System.out.println("enter rating: ");
            double rate = Double.parseDouble(key.readLine());

            song s = new song(song, rate, artist);
            List.add(s);
        }
        }else if (start == 4){
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Songs ranked from highest to lowest ");
            for (int i = 100; i >= 0; i--){
                for (int t = 0; t < List.size(); t++){
                    song now = List.get(t);
                    if (now.getRating()*10 == i){
                        count++;
                        System.out.println(count + ". " + now.getName() + " artist: " + now.getArtist()+" rating: " + now.getRating()); 
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
