package musicCollection;

/**
 * 
 * This is the album class
 * that creates an album
 * with a song and provides a
 * favorite track
 * @author Kendrick Pham
 *
 */
public class album {
	private String title;
	private String artist;
	private String genre;
	private song favoriteTrack;
	private int trackNumber;
	static int numAlbums = 0;
	
	/**
	 * album constructors
	 * 2nd constructor constructs
	 * album with default track 
	 * number 1
	 * @param title
	 * @param favoriteTrack
	 * @param trackNumber
	 */
	
	public album(String title, song favoriteTrack, int trackNumber) {
		this.title = title;
		this.favoriteTrack = favoriteTrack;
		this.artist = favoriteTrack.getArtist();
		this.genre = favoriteTrack.getGenre();
		this.trackNumber = trackNumber;
		numAlbums++;
	}
	
	public album(String title, song favoriteTrack) {
		this.title = title;
		this.favoriteTrack = favoriteTrack;
		this.artist = favoriteTrack.getArtist();
		this.genre = favoriteTrack.getGenre();
		this.trackNumber = 1;
		numAlbums++;
	}
	
	/**
	 * getter methods
	 * @return title
	 * @return favoriteTrack
	 * @return trackNumber
	 */
	
	public String getTitle() {
		return this.title;
	}
	
	public song getFavoriteTrack() {
		return this.favoriteTrack;
	}
	
	public int getTrackNumber() {
		return this.trackNumber;
	}
	
	/**
	 * setter method
	 * @param genre
	 */
	
	public void setGenre(String genre) {
		this.genre = genre;
		this.favoriteTrack.setGenre(genre);
	}
	
	/**
	 * toString method printing
	 * favorite track information
	 * @return str
	 */
	
	public String toString() {
		String str = this.title + " by " + this.artist + ": " + this.genre;
		return str;
	}
}
