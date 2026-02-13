public class Song {
    private String title, artist, album;
    private int durationSeconds;
    private int releaseYear;
    private String genre;
    public Song(String title, String artist, String album, int seconds, int year, String genre){
        this.title = title;
        this.artist = artist;
        this.album = album;
        durationSeconds = seconds;
        releaseYear = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String toString(){
        return String.format("%-15s %-13s %-15s %-6s %5s%n", title, artist, album, releaseYear, genre);
    }
    public void readSongData(){

    }
    public void searchDisplayByGenre(){

    }
    public void sortByArtist(){

    }
    public void sortByYear(){

    }
}
