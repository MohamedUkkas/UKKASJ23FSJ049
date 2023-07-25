package BasiOpenLabBook;
import java.util.Scanner;
public class FloydTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int rows, number = 1, counter, j;
		    Scanner input = new Scanner(System.in);
		    System.out.println("Enter the number of rows for floyds triangle :");
		    rows = input.nextInt();
		    System.out.println("Floyds Triangle");
		    System.out.println("*****************");
		    for ( counter = 1 ; counter <= rows ; counter++ )
		    {
		    	for ( j = 1 ; j<= counter ; j++ )
		    	{
		    		System.out.print(number+" ");
		    		number++;
		    	}
		    	System.out.println();
		    }
	}

}
