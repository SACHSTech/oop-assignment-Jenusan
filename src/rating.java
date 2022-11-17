public abstract class Rating {
    
    // intialized variabeles (i have no idea what protected means)
    protected static double rating;

    // contructor
    public Rating(double rating){
        this.rating = rating;
    }

    // gets rating
    public double getRating(){
        return this.rating;
    }

    // abstract class to get name
    public abstract String getName();
}