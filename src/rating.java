public abstract class rating {

    private int songsRated = 0;
    private int artistsRated = 0;
    private int albumsRated = 0;
    private double rating;

    public rating(double rating){
        this.rating = rating;
    }

    public abstract double getRating();
    public abstract double getName();
}