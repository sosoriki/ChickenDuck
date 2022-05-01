package changeCalculator;
import java.util.Scanner;

/**
 * This is Homework #1, Problem #1
 * This program calculates how a change should be given
 * The program starts from 20 dollar bills, to 10 dollar bills, and so on
 * @author Kendrick Pham
 */

public class changeCalculatorDriver {
	public static void main (String[] args) {
		double changeAmount = 0;
		double newAmount = 0;
		double change = 0;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter change amount: $");
		changeAmount = input.nextDouble();
		if(changeAmount > 20) {
			newAmount = changeAmount % 20;
			change = (changeAmount - newAmount)/20;
			System.out.printf("%.0f Twenty dollar bill(s)\n", change);
			changeAmount = newAmount;
		}
		if(changeAmount > 10) {
			newAmount = changeAmount % 10;
			change = (changeAmount - newAmount)/10;
			System.out.printf("%.0f Ten dollar bill(s)\n", change);
			changeAmount = newAmount;
		}
		if(changeAmount > 5) {
			newAmount = changeAmount % 5;
			change = (changeAmount - newAmount)/5;
			System.out.printf("%.0f Five dollar bill(s)\n", change);
			changeAmount = newAmount;
		}
		if(changeAmount > 1) {
			newAmount = changeAmount % 1;
			change = (changeAmount - newAmount);
			System.out.printf("%.0f One dollar bill(s)\n", change);
			changeAmount = newAmount;
		}
		if(changeAmount > 0.25) {
			newAmount = changeAmount % 0.25;
			change = (changeAmount - newAmount)/0.25;
			System.out.printf("%.0f Quarter(s)\n", change);
			changeAmount = newAmount;
		}
		if(changeAmount > 0.1) {
			newAmount = changeAmount % 0.1;
			change = (changeAmount - newAmount)/0.1;
			System.out.printf("%.0f Dime(s)\n", change);
			changeAmount = newAmount;
		}
		if(changeAmount > 0.05) {
			newAmount = changeAmount % 0.05;
			change = (changeAmount - newAmount)/0.05;
			System.out.printf("%.0f Nickel(s)\n", change);
			changeAmount = newAmount;
		}
		change = newAmount/0.01;
		System.out.printf("%.0f Pennies\n", change);
	}

}
