import java.util.*;
class BubbleSort{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter size of an array : ");
      int l = sc.nextInt();
      int arr[] = new int[l];
      System.out.println("Enter elements of array");
      for(int i=0; i<l ; i++){
         System.out.print((i+1)+"  :  ");
         arr[i] = sc.nextInt();
      }
      bubbleSort(arr);
      for(int i=0; i<l ; i++){
         System.out.print(arr[i]+"  ");
      }
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
}