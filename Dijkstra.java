import java.util.*;
class Dijkstra{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      //System.out.print("Enter no. of vertices :  ");
      //int n = sc.nextInt();
      int arr[][] = { { 100, 4, 100, 100, 100, 100, 100, 8, 100 }, { 4, 100, 8, 100, 100, 100, 100, 11, 100 }, { 100, 8, 100, 7, 100, 4, 100, 100, 2 }, { 100, 100, 7, 100, 9, 14, 100, 100, 100 }, { 100, 100, 100, 9, 100, 10, 100, 100, 100 }, { 100, 100, 4, 14, 10, 100, 2, 100, 100 },{ 100, 100, 100, 100, 100, 2, 100, 1, 6 }, { 8, 11, 100, 100, 100, 100, 1, 100, 7 }, { 100, 100, 2, 100, 100, 100, 6, 7, 100 } };
      dij(arr);
   }
   public static void dij(int[][] arr){
      int r = arr.length;
      int total = 0;
      int[] index = new int[r];
      int[] cost = new int[r];
      cost[0] = 0;
      index[0] = 0;
      for(int i = 1; i<r ; i++){
         index[i] = r+1;
      }
      int[] a = new int[3];
      for(int j = 1; j<r ; j++){
         a[0] = 100;
         for(int i : index){

            if(i<r){
               a = min(arr[i],i,a);
            }
         }
         index[j] = a[1];
         cost[j] = a[0];
         arr[a[2]][a[1]] = 100;
         arr[a[1]][a[2]] = 100;
         for(int l = 0; l<r ; l++){
            arr[l][a[1]] = 100;
         }
         for(int l = 0; l<r ; l++){
            arr[a[1]][l] = arr[a[1]][l] + a[0];
         }
      }
      
      System.out.println("Vertices     Cost");
      System.out.println((char)(index[0]+97)+"            0");
      for(int i = 1; i<r ; i++){
         System.out.println((char)(97+index[i])+"            "+(cost[i]));
      }
   }
   public static int[] min(int arr1[], int k, int[] a){
      int mini[] = a;
      for(int i =0; i<arr1.length ; i++){
         if(arr1[i]<mini[0]){
            mini[0] = arr1[i];
            mini[1] = i;
            mini[2] = k;
         }
      }
      return mini;
   }
}