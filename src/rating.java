public abstract class rating {
    
    protected static double rating;

    public rating(double rating){
        this.rating = rating;
    }

    public abstract double getRating();
    public abstract String getName();
}