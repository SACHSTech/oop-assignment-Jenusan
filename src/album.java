public class album extends rating{
    private double rating;
    private String name;
    private song song;
    private double albumCover;

    public album(String name, double rating, song song, double albumCover){
        super(rating);
        this.song = song;
        this.rating = rating;
        this.name = name;
        this.albumCover = albumCover;
    }

    public double getRating(){
        return this.rating;
    }
    public String getName(){
        return this.name;
    }
}
