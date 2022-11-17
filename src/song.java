public class Song extends Rating {


    // initilaizes variables
    private double rating;
    private String name;
    private String artist;

    // song constructor
    public Song(String name, double rating, String artist){
        super(rating);
        this.rating = rating;
        this.artist = artist;
        this.name = name;
    }

    // returns rating
    public double getSongRating(){
        return this.rating;
    }

    // returns song name
    public String getName(){
        return this.name;
    }

    // returns artist name
    public String getArtist(){
        return this.artist;
    }
    
}
