package BasiOpenLabBook;

import java.util.Scanner;

public class PrintNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("enter any number");
		int n=scan.nextInt();
		System.out.println("The entered number is :"+ n);
		scan.close();
	}

}
