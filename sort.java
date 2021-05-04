import java.util.*;
import java.time.*;
class Sort{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int[] arr = new int[100000];
      Random rand = new Random();
      for( int i = 0; i<100000 ; i++){
         arr[i] = rand.nextInt(100000);
      }
      int[] arr1 = new int[100000];
      for(int i = 0; i<arr.length ; i++){
         arr1[i] = arr[i];
      }
      int[] arr2 = new int[100000];
      for(int i = 0; i<arr.length ; i++){
         arr2[i] = arr[i];
      }
      for(int i = 0; i<arr.length ; i++){
         System.out.print(arr[i]+" ");
      }
      System.out.println();
      Instant start = Instant.now();
      insertionSort(arr);
      Instant end = Instant.now();
      System.out.println(Duration.between(start, end));
      for(int i = 0; i<arr.length ; i++){
         System.out.print(arr1[i]+" ");
      }
      System.out.println();
      Instant start1 = Instant.now();
      selectionSort(arr1);
      Instant end1 = Instant.now();
      System.out.println(Duration.between(start1, end1));
      for(int i = 0; i<arr.length ; i++){
         System.out.print(arr2[i]+" ");
      }
      System.out.println();
      Instant start2 = Instant.now();
      bubbleSort(arr2);
      Instant end2 = Instant.now();
      System.out.println(Duration.between(start2, end2));
   }
   public static void bubbleSort(int[] arr){
      int l = arr.length;
      for(int i=0; i<l-1 ; i++){
         for(int j=0 ; j<l-i-1 ; j++){
            if(arr[j] > arr[j+1]){
               int a = arr[j];
               arr[j] = arr[j+1];
               arr[j+1] = a;
            }
         }
      }
   }
   static void selectionSort(int arr[]){ 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    }
   static void insertionSort(int arr[]){
      int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        }   
   }
}