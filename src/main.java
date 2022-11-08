public class main {
    public static void main(String[] args) {
        String artist = "kanye";
        double rate = 10;
        String city = "chicago";
        String album = "graduation";
        String song = "homecoming";
        double cover = 10;


        artist kanye = new artist(artist, rate, city, new album(album, 0, new song(song, 0, ""),cover));

        System.out.println(kanye.getRating());
        System.out.println();

    }
}
