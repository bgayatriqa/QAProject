package codingExam;
/*19. What is stable algorithm? write an algorithm for quicksort.
 *  sort the fallowing using quicksort. 
 * is quick sort is stable algorithm. if not give reason. 50 70 10 40 50
 * */
import java.util.Scanner;

public class QuickSortQ19 {
	
		private int array[];
	    private int length;
	 
	    public void sort(int[] inputArr) {
	         
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        
	        this.array = inputArr;
	        length = inputArr.length;
	        quickSort(0, length - 1);
	    }
	 
	    private void quickSort(int lowerIndex, int higherIndex) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {
	            /**
	             * In each iteration, we will identify a number from left side which 
	             * is greater then the pivot value, and also we will identify a number 
	             * from right side which is less then the pivot value. Once the search 
	             * is done, then we exchange both numbers.
	             */
	            while (array[i] < pivot) {
	                i++;
	            }
	            while (array[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(i, higherIndex);
	    }
	 
	    private void exchangeNumbers(int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortQ19 sort = new QuickSortQ19();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of the array");
		int len = sc.nextInt();
		
		System.out.println("Enter elements:");
		int quickarray[] = new int[len];
		for(int i=0;i<len;i++)
			quickarray[i] = sc.nextInt();
		sc.close();
}
	}
