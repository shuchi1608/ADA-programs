import java.util.*;

import java.time.*;
import java.util.Arrays;
class QuickSort{
    static int c = 0;
    static int count = 0;
    public static void main(String args[])
	{
      Scanner sc = new Scanner(System.in);
 //     for(int j = 0; j<5;j++){
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
         quickSort(arr,0,arr.length-1);
         Instant end = Instant.now();
         System.out.println(Duration.between(start, end));
         System.out.println(count);
         for(int i = 0; i<arr.length ; i++){
            System.out.print(arr1[i]+" ");
         }
         System.out.println();
         count = 0;
         Instant start1 = Instant.now();
         quickSort(arr1,0,arr1.length-1);
         Instant end1 = Instant.now();
         System.out.println(Duration.between(start1, end1));
         int[] arr2 = new int[10000];
         System.out.println(count);
         for(int i = 0; i<arr.length ; i++){
            arr2[i] = arr[10000-i-1];
         }
         for(int i = 0; i<arr.length ; i++){
            System.out.print(arr2[i]+" ");
         }
         System.out.println();
         count = 0;
         Instant start2 = Instant.now();
         quickSort(arr2,0,arr2.length-1);
         Instant end2 = Instant.now();
         System.out.println(Duration.between(start2, end2));
         System.out.println(count);
         for(int i = 0; i<arr.length ; i++){
            System.out.print(arr3[i]+" ");
         }
         System.out.println();
         count = 0;
         Instant start3 = Instant.now();
         quickSort(arr3,0,arr3.length-1);
         Instant end3 = Instant.now();
         System.out.println(Duration.between(start3, end3));
         System.out.println(count);
//      }
   } 
    public static void quickSort(int []arr,int beg,int end){
       if(beg<end){
           c++;
           int num = partition(arr,beg,end);
           quickSort(arr,beg,num-1);
           quickSort(arr,num+1,end);  
       } 
       count++;  
    }
    public static int partition(int arr[], int beg, int end){
       int loc = beg;
       int r = end;
       int flag = 0;
       while(flag==0){
           while(arr[loc]<=arr[r] && loc!=r){
               r=r-1;
           }
           if(loc==r){ 
               flag=1;
           }
           else if(arr[loc]>arr[r]){
               int temp = arr[loc];
               arr[loc] = arr[r];
               arr[r] = temp;
               loc=r;
           }
           if(flag == 0){
               while(arr[loc] >= arr[beg] && loc != beg){
                   beg = beg +1;
               }
               if(loc == 1){
                   flag = 1;
               }
               else if(arr[loc]<arr[beg]){
                   int temp = arr[loc];
                   arr[loc] = arr[beg];
                   arr[beg] = temp;
                   loc=beg;
               }
           }
       }
       return loc;
    }
} 