package musicCollection;
import java.util.Scanner;

/**
 * 
 * the driver class for the
 * musicCollection project.
 * creates songs and albums 
 * and prints out their params
 * @author Kendrick Pham
 *
 */

public class musicCollection {
	static Scanner input = new Scanner(System.in);														//global scanner
	
	/**
	 * 
	 * the main method of the class
	 * creates the songs and albums
	 * and runs the main while loop
	 * of the program
	 * @param args
	 * 
	 */
	
	public static void main(String[] args) {
		song song1 = new song("Never gonna give you up", "Rick Astley", "Meme song");
		song song2 = new song("Baby", "Justin Bieber", "Pop");
		song song3 = new song("Grenade", "Bruno Mars");
		album album1 = new album("Whenever you need somebody", song1, 1);
		album album2 = new album("My World 2.0", song2, 3);
		album album3 = new album("Doo-Wops & Hooligans", song3);
		int choice = 1;
		while(choice == 0 || choice == 1 || choice == 2 || choice == 3) {
			System.out.printf("Album Selection:\n[1] %s\n[2] %s\n[3] %s\nSelect an Album (0 to quit): ", album1.getTitle(), album2.getTitle(), album3.getTitle());
			choice = input.nextInt();
			System.out.printf("\n");
			if(choice == 0) {
				System.out.printf("Goodbye!\n");
				System.exit(0);
			}
			else if(choice == 1) {
				albumOptions(album1);
			}
			else if(choice == 2) {
				albumOptions(album2);
			}
			else if(choice == 3) {
				albumOptions(album3);
			}
			else {
				System.out.printf("You didn't enter a valid option!\n");
				System.exit(0);
			}
		}
	}
	
	/**
	 * 
	 * this is the album options 
	 * loop that loops through the menu
	 * for the album that is chosen
	 * in main. will break out of this method
	 * when 0 is inputed
	 * @param album
	 * 
	 */

	public static void albumOptions(album album) {
		int choice = 1;
		System.out.printf("%s\n", album.toString());
		while(choice != -99999) {
			System.out.printf("Album Options:\n[1] Get Favorite Track\n[2] Change Genre\n[0] Return\nSelection: ");
			choice = input.nextInt();
			System.out.printf("\n");
			if (choice == 1) {
				System.out.printf("%s\n", album.getFavoriteTrack().toString(album.getTrackNumber()));
			}
			if (choice == 2) {
				System.out.printf("New Genre: ");
				input.nextLine();																								//using to buffer between nextInt() and nextLine()
				String newGenre = input.nextLine();
				album.setGenre(newGenre);
				System.out.printf("\n");
			}
			if (choice == 0) {																									//breaks out of this method to go back to main's while loop
				break;
			}
		}
	}

}


/**
 * Collaborative Statement
 * 
 * Working on this project, there were times
 * when I was hit with a simple bug that
 * took me half an hour to fix. It was just
 * because I was missing a line of code. Sometimes
 * it is better for the mind if I took short
 * breaks so that I can come back and fix bugs
 * with a fresh mind instead of going at it for
 * a long period of time.
 * 
 */
