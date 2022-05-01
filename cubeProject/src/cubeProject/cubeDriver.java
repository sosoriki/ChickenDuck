package cubeProject;
import java.util.Scanner;

/**
 * 
 * This is the cube driver that uses the cube class
 * It takes user inputs for length and prints out the surface and volume of the cube
 * @author Kendrick Pham
 *
 */

public class cubeDriver {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Please enter the length for a cube: ");
		double length = input.nextDouble();
		cube cube = new cube(length);											//using the constructor to create a cube with the user inputed length
		System.out.printf("Surface Area: %.2f\n", cube.surfaceArea());
		System.out.printf("Volume: %.2f", cube.volume());
	}
}
