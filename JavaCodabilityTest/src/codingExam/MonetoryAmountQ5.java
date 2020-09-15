package codingExam;
/*Q5)Write a program to read monetary amount in cents and 
print the smallest possible number of coins equaling the amount. 
 * Example: monetary amount in cents=288 2 Dollar 3 quarter 1 dime 3 pennies 
 * So smallest possible number of coins equaling the amount 283====9 coins
 * */
import java.util.Scanner;

public class MonetoryAmountQ5 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the amount in cents ");
//		int cents =sc.nextInt();
    int cents =97;
		int dollar=cents%100;
		int dollarModular=cents/100;
		System.out.println("dollar "+dollar);
		System.out.println("dollarModular "+dollarModular);
		if(dollarModular==0)
		{
			System.out.println("The smallest number of coins is "+dollarModular);
		}
		
		int quaters= dollar%25;
		int quaterModular=dollar/25;
		System.out.println("quaters "+quaters);
		System.out.println("quaterModular "+quaterModular);
		 if(quaterModular==0)
		{
			System.out.println("The smallest number of coins is "+(quaterModular+dollarModular));
		}
		
		int dime =quaters%10;
		int dimeModular =quaters/10;
		System.out.println("dime "+dime);
		System.out.println("dimeModular "+dimeModular);
		 if(dimeModular==0)
		{
			System.out.println("The smallest number of coins is "+(dimeModular+quaterModular+dollarModular));
		}
		
		 if(dime<10)
		{
		System.out.println("The smallest number of coins is "+(dime+dimeModular+quaterModular+dollarModular));	
		}
		
			
			
		
	}

}
