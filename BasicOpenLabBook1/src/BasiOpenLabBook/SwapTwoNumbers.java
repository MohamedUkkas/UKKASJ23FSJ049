package BasiOpenLabBook;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float first = 2.50f, second = 45.50f;
	       System.out.println("--Before swap--");
	       System.out.println("First number = " + first);
	       System.out.println("Second number = " + second);
	       float temporary = first;
	       first = second;
	       second = temporary;
	       System.out.println("--After swap--");
	       System.out.println("First number = " + first);
	       System.out.println("Second number = " + second);
	}

}