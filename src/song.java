public class Song extends Rating {


    // initilaizes variables
    private double rating;
    private String name;
    private String artist;

    /**
     * 
     * @param name input name of song
     * @param rating input rating
     * @param artist input artists
     */
    public Song(String name, double rating, String artist){
        super(rating);
        this.rating = rating;
        this.artist = artist;
        this.name = name;
    }

    /**
     * @return gets rating
     */
    public double getSongRating(){
        return this.rating;
    }

    /**
     * gets name
     */
    public String getName(){
        return this.name;
    }

    /**
     * gets artist
     * @return
     */
    public String getArtist(){
        return this.artist;
    }
    
}
