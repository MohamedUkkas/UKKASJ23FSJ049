package BasiOpenLabBook;

import java.util.Scanner;

public class WhileLoopDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int number, sum = 0;
		    Scanner sc = new Scanner(System.in);
		    System.out.println("n please Enter any integer Value below 10:");
		    number = sc.nextInt();
		    while (number <= 10) {
		    	sum = sum + number;
		    	number++;
		    }
		    System.out.format("Sum of the Number From the While Loop is: %d ",sum);
	}

}
