public class song extends rating {

    public double rating;
    public String name;

    public song(String name, double rating, String artist){
        super(rating);
        this.rating = rating;
    }

    public double getRating(){
        return this.rating;
    }

    public String getName(){
        return this.name;
    }
    
}
