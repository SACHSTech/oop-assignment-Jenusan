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
    static int filler = 0;

    static double rate = -1;

    static String rateString = "";


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
        try {
        start = Integer.parseInt(key.readLine());
        if (start == 0){
            quit = true;
        }
        if (start < 0 || start > 4){
            System.out.println("");
            System.out.println("Enter a viable option pal..");
            System.out.println("");
        }
        } catch (Exception e){
            System.out.println("");
            System.out.println("Enter a viable option pal..");
            System.out.println("");
        }
    }

    public static void songInputs()throws IOException{
        if (start == 1){
            while (ask){
                System.out.println("");
                System.out.println("input (0) to quit");
                System.out.print("enter song name: ");
                String song = input.readLine();
                if (song.equals("")){
                    while(song.equals("")){
                    System.out.println("");
                    System.out.println("Not a real song name bud...");
                    System.out.println("");
                    System.out.print("enter song name: ");
                    song = input.readLine();
                    }
                }
                if (song.equals("0")){
                    start = 0;
                    break;
                }
                System.out.print("enter artist name: ");
                String artist = input.readLine();
                if (artist.equals("")){
                    while(artist.equals("")){
                    System.out.println("");
                    System.out.println("Not a real artist name bud...");
                    System.out.println("");
                    System.out.print("enter artist name: ");
                    artist = input.readLine();
                    }
                }

                while(rateString.equals("")){
                System.out.print("enter rating from 0-10: ");
                rateString = input.readLine();
                if (rateString.equals("")){
                    while(rateString.equals("")){
                    System.out.println("");
                    System.out.println("Enter Valid number from 0-10");
                    System.out.println("");
                    System.out.print("enter rating from 0-10: ");
                    rateString = input.readLine();
                    }
                }
                    rate = Double.valueOf(rateString);
                    if (rate < 0 || rate > 10){
                        while(rate < 0 || rate > 10){
                        System.out.println("");
                        System.out.println("From 1-10...");
                        System.out.println("");
                        System.out.print("enter rating from 1-10: ");
                        rate = Double.parseDouble(key.readLine());
                        }

                        song s = new song(song, rate, artist);
                        rank.add(s);
                        fav.add(s);
                        songRanks.addeth(s);
                        System.out.println("");
                        System.out.println("From 1-10...");
                        System.out.println("");
                    }
                }
                        

                rateString = "";
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
                while (album.equals("")){
                    System.out.println("");
                    System.out.println("Not a valid album name and you know it");
                    System.out.println("");
                    System.out.println("input (0) to quit");
                    System.out.print("enter album name: ");
                    album = input.readLine();
                }
                if (album.equals("0")){
                    break;
                }

                System.out.print("enter artist name: ");
                String artist = input.readLine();
                while (artist.equals("")){
                    System.out.println("");
                    System.out.println("Not a valid artist name and you know it");
                    System.out.println("");
                    System.out.print("enter artist name: ");
                    artist = input.readLine();
                }

                while (albumFiller){
                System.out.println("");
                System.out.println("input (0) to add new album");
                System.out.print("enter song name: ");
                String name = input.readLine();
                while (name.equals("")){
                    System.out.println("");
                    System.out.println("Enter valid song name");
                    System.out.println("");
                    System.out.println("input (0) to add new album");
                    System.out.print("enter song name: ");
                    name = input.readLine();
                }
                if (name.equals("0")){
                    if (filler == 0){
                        System.out.println("No inputs... deleting album");
                        break;
                    }else{
                        now = new album(album, songList);
                        albumStats.addAlbum(now);
                        break;
                    }
                }

                System.out.print("enter rating from 0-10: ");
                String albumRateString = input.readLine();

                if (albumRateString.equals("")){
                    while(albumRateString.equals("")){
                    System.out.println("");
                    System.out.println("Enter Valid rating from 0-10");
                    System.out.println("");
                    System.out.print("enter rating from 0-10: ");
                    albumRateString = input.readLine();
                    }
                }
                    rate = Double.valueOf(albumRateString);

                    
                    if (rate < 0 || rate > 10){
                        while(rate < 0 || rate > 10){
                        System.out.println("");
                        System.out.println("From 0-10...");
                        System.out.println("");
                        System.out.print("enter rating from 1-10: ");
                        albumRateString = input.readLine();
                        }
                    }

                song songs = new song(name, rate, artist);
                songList.add(songs);
                filler++;

                }
                
            }
            }
    }

    public static void stats()throws IOException{
        if (start == 3){
            if (songRanks.getLength() == 0){
                System.out.println("");
                System.out.println("No songs to rank genius");
            }else{
                songRanks.ranketh();
                songRanks.fav();
                backToNAV();
            }
        }
    }

    public static void albumStats()throws IOException{
        if (start ==4){
            if (albumStats.getLength() == 0){
                System.out.println("");
                System.out.println("No album to rank genius");
            }else{
                albumStats.albumInfo();
                albumStats.favAlbum();
                backToNAV();
            }
        }
    }
}