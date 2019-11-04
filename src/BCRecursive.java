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

public class BCRecursive {

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
	
	/**
	 * checks if the value entered for k is zero or n equals k and continues to iterate through numbers
	 * lower than n and k until they meet one of the two requirements and then adds them to the results
	 * @param n
	 * @param k
	 */
	public static void calc(int n, int k) {
		if ((n == k ) || (k == 0)) {
			results++;
		}//end if
		else {
			calc(n-1, k);
			calc(n-1, k-1);
		}//end else
	}//end calc
	
	/**
	 * groups all the other blocks to compose the entire program
	 */
	public static void run() {
		
		N();
		aTime = System.nanoTime();
		calc(n, k);
		bTime = System.nanoTime();
		cTime = ((bTime - aTime)/1000000000);
		System.out.println("There are "+results+ " ways to "+k+" subsets from "+n+" items.");	
			toFile();
			restart();
		}//end run
	
	/**
	 * saves results to a text file
	 */
	public static void toFile() {
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("BCRecursion.txt", true));
		if(cTime < 1) {
			writer.append(n + ", " + k + ", " + results + ", 1 second.");
			writer.newLine();
			writer.close();
		}else {
			writer.append(n + ", "  +k + ", "+results+", " + cTime + " seconds.");
			writer.newLine();
			writer.close();
		}//else
	} catch (IOException ex) {
		System.out.print("toFile Failed");
	}//end catch
	}//end to toFile
	
	/**
	 * method to restart program
	 */
	public static void restart() {
		System.out.println("Would you like to enter N and K again? Y/N ");
		if(input.next().equalsIgnoreCase("Y")) {
			run();
		}//end if
		else if(input.next().equalsIgnoreCase("N")) {
			System.out.print("END");
		}//end else if
		
	}//end restart
	
	public static void main(String[] args) {
		run();
	}//end main
	
}//end class
