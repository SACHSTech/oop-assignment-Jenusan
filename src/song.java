public class song extends rating {

    public double rating;
    public String name;
    public String artist;

    public song(String name, double rating, String artist){
        super(rating);
        this.rating = rating;
        this.artist = artist;
        this.name = name;
    }

    public double getRating(){
        return this.rating;
    }

    public String getName(){
        return this.name;
    }

    public String getArtist(){
        return this.artist;
    }
    
}
