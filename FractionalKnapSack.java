import java.util.*;
import java.text.*;
public class FractionalKnapSack {
	private static double getMaxValue(float[] wt, float[] val,float capacity){
      double max = 0;
      int n = wt.length;
      float temp;
      float array[] = new float[n];
      for(int i = 0; i<n;i++){
         array[i] = val[i]/wt[i];
      }
      for(int i = 0; i<n; i++){
         for(int j =0; j<n-1 ; j++){
            if(array[j]<array[j+1]){
               temp = array[j];
               array[j] = array[j+1];
               array[j+1] = temp;
               temp = wt[j];
               wt[j] = wt[j+1];
               wt[j+1] = temp;
               temp = val[j];
               val[j] = val[j+1];
               val[j+1] = temp;
            }
         }
      }
      float arr[] = new float[n];
      int i = 0;
      while(capacity>0 && i<n){
         if(wt[i]<=capacity){
            capacity = capacity - wt[i];
            arr[i] = wt[i];
            max = max + val[i];
         }
         else if(wt[i]>capacity && capacity!=0){
            arr[i] = capacity;
            max = max + array[i]*capacity;
            capacity = 0;
         }
         i++;
      }
      DecimalFormat df = new DecimalFormat("##0.000");
      System.out.println("Value    Weight    value/weight    xi        Profit");
      for(i=0; i<n ; i++){
         if(array[i] < 10){
            System.out.println(val[i]+"    "+wt[i]+"      "+df.format(array[i])+"           "+df.format(arr[i]/wt[i])+"     "+(array[i]*arr[i]));
         }
         if(array[i] >= 10){
            System.out.println(val[i]+"    "+wt[i]+"      "+df.format(array[i])+"          "+df.format(arr[i]/wt[i])+"     "+(array[i]*arr[i]));
         }
      }
		return max;
	}
	public static void main(String[] args)
	{
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the number of values :  ");
      int n = sc.nextInt();
		float[] wt = new float[n];
		float[] val = new float[n];
      Random rand = new Random();
      for( int i = 0; i<n ; i++){
         val[i] = rand.nextInt(1000-100) + 100;
      }
      for( int i = 0; i<n ; i++){
         wt[i] = rand.nextInt(100-10)+10;
      }
		float capacity;
      System.out.print("Enter the capacity :  ");
      capacity = sc.nextFloat();
      
		double maxValue = getMaxValue(wt, val, capacity);

		// Function call
		System.out.println("Maximum value we can obtain = "+ maxValue);
	}
}