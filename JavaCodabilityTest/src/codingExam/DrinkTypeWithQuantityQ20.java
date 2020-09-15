package codingExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DrinkTypeWithQuantityQ20 {

	public static void main(String[] args) {
		Map<String,Integer> hmap = new HashMap<>();
		hmap.put("cola",9);
		hmap.put("fanta",6);
		Scanner scr = new Scanner(System.in);
		System.out.println("Choose a drink from Cola and Fanta");
		String drinkName = scr.next();
		
		
		if(hmap.containsKey(drinkName)) {
			if(hmap.get(drinkName)>=1) {
			System.out.println(drinkName+" is Served");
			hmap.put(drinkName, hmap.get(drinkName)-1);
			System.out.println("Remaining drinks: "+hmap);
			} else 
			{
			System.out.println(drinkName+" is not avaiable");
		    }
		}
		else {
			System.out.println("");
		}
			
		
	
		
}
}
