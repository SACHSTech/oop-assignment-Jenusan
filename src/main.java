import java.util.ArrayList;
import java.io.*;

public class main {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<song> List = new ArrayList();

        double x = 1;

        while ( x != 0){
            System.out.println("enter song name: ");
            String song = input.readLine();
            System.out.println("enter rating: ");
            double rate = Double.parseDouble(key.readLine());
            System.out.println("enter artist name: ");
            String artist = input.readLine();


            song s = new song(song, rate, artist);

            List.add(s);



            System.out.println("cancel?: ");
            x = Double.parseDouble(key.readLine());
        }

        for (int i = 0; i < List.size(); i++){
            song now = List.get(i);
            System.out.println(now.getName() +" rating: " + now.getRating() + " artist: " + now.getArtist());
        }

    }
}
