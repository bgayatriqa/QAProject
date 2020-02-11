

import java.util.Scanner;

public class StringOrNumPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter the string or number ");
		String name = scr.nextLine();
		String  reverse ="";
		System.out.println("the length is "+name.length());
		System.out.println("Entered String "+name);
		for(int i=name.length()-1;i>=0;i--)

		{
			reverse = reverse+name.charAt(i);
		}
			System.out.println("Reversed string "+reverse);

		if(name.contentEquals(reverse))
		{
			System.out.println("palandrome "+"length is "+name.length());
		}
		else
		System.out.println("not palandrome");
		 			

			scr.close();
		
	}
}

