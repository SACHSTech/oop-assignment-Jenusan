import java.util.ArrayList;
import java.io.*;

public class main {

    // initializing arraylists and buffer readers
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Song> rank = new ArrayList<Song>();
    static ArrayList<Song> fav = new ArrayList<Song>();
    static ArrayList<ArrayList<Song>> List = new ArrayList<ArrayList<Song>>();
    static ArrayList<Double> sums = new ArrayList<Double>();

    // initiallizing global variables
    static Album now;
    static SongRanker songRanks;
    static AlbumRanker albumStats;

    static boolean quit = false;
    static boolean why = true;

    static int start;
    static int songCounter;
    static int filler = 0;

    static double rate = -1;

    private static void main(String[] args) throws IOException{
        // constructs rankers
        songRanks = new SongRanker();
        albumStats = new AlbumRanker();

        //prints welcome screen
        System.out.println("");
        System.out.println("WELCOME TO SPOTIFYE");
        System.out.println("Use this fire user interface to navigate through rating your favorite albums and songs");
        System.out.println("If you want to see your stats after inputting them, press the stats sections");
        System.out.println("");
        while (quit == false){
            NAV();
            SongInputs();
            AlbumInputs();
            AlbumStats();
            Stats();
        }
    }

    // sends users back to nav
    private static void BackToNAV() throws IOException{
        System.out.println("");
        System.out.println("press ENTER key to return to NAV");
        String next = input.readLine();

        if (next == ""){
            start = 0;
        }else{
            start = 0;
        }
    }

    // navigation interface
    private static void NAV()throws IOException{
        System.out.println("");
        System.out.println("Press 0 to quit");
        System.out.println("Press keys 1-4 to navigate");
        System.out.println("Rate Songs    |(1) ");
        System.out.println("Rate Albums   |(2) ");
        System.out.println("Song stats    |(3) ");
        System.out.println("Album stats   |(4) ");

        // try and catch is lowkey pretty cool 
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

    // gathers inputs for songs
    private static void SongInputs()throws IOException{
        if (start == 1){
            while (true){
                // initial prompts
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

            // putting all gathered values into a song constructor
            Song s = new Song(song, rate, artist);
            // adding songs to arraylists
            rank.add(s);
            fav.add(s);
            songRanks.addeth(s);
                
    }
}
    }

    // gathers inputs for albums 
    private static void AlbumInputs()throws IOException{
        if (start == 2){
            while (true){
                // new arraylist each runthrough
                ArrayList<Song> songList = new ArrayList<Song>();

                // prompts
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

                while (true){
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
                        // puts all gathered info into album object
                        now = new Album(album, songList);
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

                // puts each song and rating into a new song
                Song songs = new Song(name, rate, artist);
                songList.add(songs);
                filler++;

                }
                
            }
            }
    }

    // shows song stats
    private static void Stats()throws IOException{
        if (start == 3){
            if (songRanks.getLength() == 0){
                System.out.println("");
                System.out.println("No songs to rank genius");
            }else{
                songRanks.ranketh();
                songRanks.fav();
                BackToNAV();
            }
        }
    }

    // shows albunm stats
    private static void AlbumStats()throws IOException{
        if (start ==4){
            if (albumStats.getLength() == 0){
                System.out.println("");
                System.out.println("No album to rank genius");
            }else{
                albumStats.albumInfo();
                albumStats.favAlbum();
                BackToNAV();
            }
        }
    }
}