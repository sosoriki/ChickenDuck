package musicCollection;

/**
 * 
 * This is the song class that creates
 * an instance of a song with
 * title, artist, and genre
 * @author Kendrick Pham
 *
 */
public class song {
	private String title;
	private String artist;
	private String genre;
	
	/**
	 * 
	 * Constructor methods that uses
	 * title, artist, and if included genre 
	 * to make a song instance
	 * 2nd constructor creates a song
	 * with an unknown genre
	 * @param title
	 * @param artist
	 * @param genre
	 */
	
	public song(String title, String artist, String genre) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
	}
	
	public song(String title, String artist) {
		this.title = title;
		this.artist = artist;
		this.genre = "Unknown";
	}
	
	/**
	 * getter methods
	 * @return title
	 * @return artist
	 * @return genre
	 */

	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	/**
	 * setter methods
	 * @param title
	 * @param artist
	 * @param genre
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * toString override method
	 * to print title, artist, and genre
	 * @return str
	 */
	
	public String toString(int trackNumber) {
		String str = "Track No. " + trackNumber + ": " + this.artist + " - " + this.title + ", Genre: " + this.genre + "\n";
		return str;
	}
}
