

import java.util.Scanner;

public class TwoArraysMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the length of an array");
		int alength = s.nextInt();
		int a[] = new int[alength];

		System.out.println("Enter A array elements");
		for (int i = 0; i <= alength - 1; i++) {
			a[i] = s.nextInt();
		}
		System.out.println("Enter the length of an array");
		int blength = s.nextInt();
		int b[] = new int[blength];
		System.out.println("Enter B array elements");
		for (int i = 0; i <= blength - 1; i++) {
			b[i] = s.nextInt();
		}
		
		int i=0,j=0,k=0,c[]= new int[alength+blength];
		int aLast =a.length;
		int bLast = b.length;
		while((i<aLast)&&(j<bLast))
		{
			if(a[i]>b[j])
			{
				c[k]=b[j];
				k++;
				j++;
			}
			else
			{
				c[k] = a[i];
				k++;
				i++;
			}
		}
		if(j==b.length)
		{
			while(i<a.length)
		{
			c[k]=a[i];
			k++;
			i++;
		}
	}
		else if(i==a.length)
		{
			
			while(j<b.length)
		{
			c[k]=b[j];
			k++;
			j++;
		}
		}
		for(int index=0;index<c.length;index++)
		{
			System.out.println(c[index]);
		}
	}

}
