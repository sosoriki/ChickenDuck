package cubeProject;

/**
 * 
 * This is the cube class to create a cube
 * @author Kendrick Pham
 *
 */

public class cube {
	private double sideLength;
	
	public cube(double sideLength) {
		this.sideLength = sideLength;										//sets length to what is passed through constructor
	}
	
	public double surfaceArea() {											//calculates surface area of the cube
		double value;
		value = 6 * (this.sideLength * this.sideLength);
		return value;
	}
	
	public double volume() {												//calculates volume of the cube
		double value;
		value = this.sideLength * this.sideLength * this.sideLength;
		return value;
	}
																			//code could probably be optimized with surface and volume being in one line
}
