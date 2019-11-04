import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
//imports

/*
 * 
 * @author Marlon Cabrera
 * @version Nov 4, 2019
 * Recursion Project
 * Fall 2019
 */

public class BCDynamic {

	private static int n;
	private static int k;
	private static double aTime;
	private static double bTime;
	private static double cTime;
	private static int results;
	
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * Prompts the user to enter a value for N and if entry is invalid asked to user if they would
	 * like to try a new value
	 */
	public static void N(){
		System.out.print("Enter a value for N: ");
		if(input.hasNextBigInteger()) {
			n = input.nextInt();
			K();
		}//end if
		else {
			System.out.print("Invalid entry. Try a new value? Y/N ");	
			if(input.next().equalsIgnoreCase("Y")) {
				N();
			}//end if
		}//end else
		
	}//end N
	
	/**
	 * Prompts the user to enter a value for K and if entry is invalid asked to user if they would
	 * like to try a new value
	 */
	public static void K() {
		System.out.print("Enter a value for K: ");
		if(input.hasNextInt()) {
			k = input.nextInt();
		if(k > n) {
			System.out.print("Invalid entry. Try a new value? Y/N ");
			if(input.next().equalsIgnoreCase("Y")) {
				K();
			}//end if
		}//end if
		}//end if
		else {
			System.out.print("Invalid entry. Try a new value? Y/N ");
			if(input.next().equalsIgnoreCase("Y")) {
				K();
			}//end if
		}//end else
		
	}//end K
	
	
	
}//end class
