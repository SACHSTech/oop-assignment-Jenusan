public abstract class Rating {
    
    // intialized variabeles (i have no idea what protected means)
    protected static double rating;

    /**
     * 
     * @param rating input rating
     */
    public Rating(double rating){
        this.rating = rating;
    }

    /**
     * 
     * @return rating 
     */
    public double getRating(){
        return this.rating;
    }

    // abstract class to get name
    public abstract String getName();
}