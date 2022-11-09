import java.util.ArrayList;
import java.io.*;

public class main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<song> List = new ArrayList();
        boolean ask = true;
        int count = 0;


        while (ask){
            System.out.println("enter song name: ");
            String song = input.readLine();
            if (song.equals("0")){
                break;
            }
            System.out.println("enter artist name: ");
            String artist = input.readLine();
            System.out.println("enter rating: ");
            double rate = Double.parseDouble(key.readLine());

            song s = new song(song, rate, artist);
            List.add(s);
        }

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

    }
}
