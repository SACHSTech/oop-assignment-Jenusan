
public class artist {

    public String name;
    public double rating;
    public String from;
    public artist(String name, double rating, String from, album album){
        this.name = name;
        this.rating = rating;
        this.from = from;
    }
    
    public double getRating(){
        return this.rating;
    }

    public String getName(){
        return this.name;
    }

}
