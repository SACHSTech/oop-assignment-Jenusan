public class song extends rating {

    public double rating;
    public String name;
    public String artist;

    public song(String name, double rating, String song){
        super(rating);
        this.rating = rating;
        this.artist = song;
        this.name = name;
    }

    public double getSongRating(){
        return this.rating;
    }

    public String getName(){
        return this.name;
    }

    public String getArtist(){
        return this.artist;
    }
    
}
