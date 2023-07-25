package BasiOpenLabBook;

import java.util.Scanner;

public class FindAreaOfSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Enter Side of Square:");
         Scanner scanner = new Scanner(System.in);
         double side = scanner.nextDouble();
         double area = side*side;
         System.out.println("Areas of Square is: "+area);
	}

}
