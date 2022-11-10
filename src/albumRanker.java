import java.util.ArrayList;

public class albumRanker {

    public static ArrayList<album> albumRank;
    public static ArrayList<song> SongsInAlbum;
    public static ArrayList<ArrayList> songsPerAlbum;
    private int count = 0;
    
    public albumRanker(){
        albumRank = new ArrayList<album>();
        SongsInAlbum = new ArrayList<song>();
        songsPerAlbum = new ArrayList<ArrayList>();
    }

    public void addAlbum(album album){
        albumRank.add(album);
    }

    public void addSong(song song){
        SongsInAlbum.add(song);
    }

    public void count(){
        count++;
    }

    public void addSet(ArrayList list){
        songsPerAlbum.add(list);
    }

    public void wipe(){
        SongsInAlbum.removeAll(SongsInAlbum);
    }

    public void albumInfo(){
        for (int i = 0; i < albumRank.size(); i++){
        album nowAlbum = albumRank.get(i);
        ArrayList<song> nowlist = songsPerAlbum.get(i);
        System.out.println(nowAlbum.getName() + " by: " + nowAlbum.getArtist());
        for(int x = 0; x < count; x++){
            song nowSong = nowlist.get(x);
            System.out.println(nowSong.getName() + " " + nowSong.getRating());
        }
    }
    }


    
}
