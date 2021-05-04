import java.util.*;
import java.text.*;
public class ZeroOneKnapSack {
	private static double MaxValue(int[] wt, int[] val,int capacity){
      int n = wt.length;
      int temp;
      for(int i = 0; i<n; i++){
         for(int j =0; j<n-1 ; j++){
            if(wt[j]>wt[j+1]){
               temp = wt[j];
               wt[j] = wt[j+1];
               wt[j+1] = temp;
               temp = val[j];
               val[j] = val[j+1];
               val[j+1] = temp;
            }
         }
      }
      int array[][] = new int[n][capacity+1];
      for(int i = 0; i<n; i++){
         for(int j = 0; j<capacity +1 ; j++){
            if(j==0 || (i==0 && wt[i]>j)) array[i][j] = 0;
            else if(i==0 && wt[i]<=j){
               array[i][j]=val[i];
            }
            else{
               if(wt[i]>j){
                  array[i][j] = array[i-1][j];
               }
               else{
                  if((val[i]+array[i-1][j-wt[i]])>array[i-1][j]) array[i][j] = val[i]+array[i-1][j-wt[i]];
                  else array[i][j] = array[i-1][j];
               }
            }
         }
      }
      System.out.println("Value    Weight");
      for(int i=0; i<n ; i++){
         System.out.println(val[i]+"     "+wt[i]);
      }
		return array[n-1][capacity];
	}
	public static void main(String[] args)
	{
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the number of values :  ");
      int n = sc.nextInt();
		int[] wt = {4,3,6,2};
		int[] val = {12,7,16,20};
      Random rand = new Random();
      //val = ;
      //for( int i = 0; i<n ; i++){
        // val[i] = rand.nextInt(1000-100) + 100;
      //}
      //for( int i = 0; i<n ; i++){
        // wt[i] = rand.nextInt(100-10)+10;
      //}
      //wt = ;
 		int capacity;
      System.out.print("Enter the capacity :  ");
      capacity = sc.nextInt();
		double maxValue = MaxValue(wt, val, capacity);

		// Function call
		System.out.println("Maximum value we can obtain = "+ maxValue);
	}
}