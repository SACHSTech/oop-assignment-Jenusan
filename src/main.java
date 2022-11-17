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

    static boolean why = true;

    static int start;
    public static int songCounter;
    static int filler = 0;

    static double rate = -1;


    public static void main(String[] args) throws IOException{
        songRanks = new songRanker();
        albumStats = new albumRanker();
        System.out.println("");
        System.out.println("WELCOME TO FREEKANYE.COM");
        System.out.println("Use this fire user interface to navigate through rating your favorite albums and songs");
        System.out.println("If you want to see your stats after inputting them, press the stats sections");
        System.out.println("");
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
        System.out.println("press ENTER key to return to NAV");
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

                while (why == true){
                try{
                System.out.print("enter rating from 0-10: ");
                rate = Double.parseDouble(key.readLine());
                if (rate <= 10 && rate >= 0){
                    why = false;
                }else{
                    System.out.println("Value must be from 0-10: ");
                }
                }catch(Exception E){
                    System.out.println("");
                    System.out.println("Value must be from 0-10: ");
                }
            }
            why = true;

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
                System.out.println("input (0) when finished with album");
                System.out.print("enter song name: ");
                String name = input.readLine();
                while (name.equals("")){
                    System.out.println("");
                    System.out.println("Enter valid song name");
                    System.out.println("");
                    System.out.println("input (0) when finished with album");
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

                while (why == true){
                    try{
                    System.out.print("enter rating from 0-10: ");
                    rate = Double.parseDouble(key.readLine());
                    if (rate <= 10 && rate >= 0){
                        why = false;
                    }else{
                        System.out.println("Value must be from 0-10: ");
                    }
                    }catch(Exception E){
                        System.out.println("");
                        System.out.println("Value must be from 0-10: ");
                    }
                }
                why = true;

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