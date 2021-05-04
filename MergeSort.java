import java.util.*;
import java.time.*;
import java.util.Arrays;
class MergeSort 
{

	static void merge(int arr[], int l, int m, int r)
	{

		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];


		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	static void mergesort(int arr[], int l, int r)
	{
		if (l < r) {
			int m = (l + r) / 2;
 			mergesort(arr, l, m);
			mergesort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	public static void main(String args[])
	{
      Scanner sc = new Scanner(System.in);
      for(int j = 0; j<5;j++){
         int[] arr = new int[10000];
         Random rand = new Random();
         for( int i = 0; i<10000 ; i++){
            arr[i] = rand.nextInt(10000);
         }
         int[] arr1 = new int[10000];
         for(int i = 0; i<arr.length ; i++){
            arr1[i] = arr[i];
         };
         Arrays.sort(arr1);
         int[] arr3 = new int[10000];
         for(int i = 0; i<arr.length ; i++){
            arr3[i] = 253648;
         }
         for(int i = 0; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
         }
         System.out.println();
         Instant start = Instant.now();
         mergesort(arr,0,arr.length-1);
         Instant end = Instant.now();
         System.out.println(Duration.between(start, end));
         for(int i = 0; i<arr.length ; i++){
            System.out.print(arr1[i]+" ");
         }
         System.out.println();
         Instant start1 = Instant.now();
         mergesort(arr1,0,arr1.length-1);
         Instant end1 = Instant.now();
         System.out.println(Duration.between(start1, end1));
         int[] arr2 = new int[10000];
         for(int i = 0; i<arr.length ; i++){
            arr2[i] = arr[10000-i-1];
         }
         for(int i = 0; i<arr.length ; i++){
            System.out.print(arr2[i]+" ");
         }
         System.out.println();
         Instant start2 = Instant.now();
         mergesort(arr2,0,arr2.length-1);
         Instant end2 = Instant.now();
         System.out.println(Duration.between(start2, end2));
         for(int i = 0; i<arr.length ; i++){
            System.out.print(arr3[i]+" ");
         }
         System.out.println();
         Instant start3 = Instant.now();
         mergesort(arr3,0,arr3.length-1);
         Instant end3 = Instant.now();
         System.out.println(Duration.between(start3, end3));
      }
   }

}