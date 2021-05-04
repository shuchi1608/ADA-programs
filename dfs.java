import java.util.*;
public class dfs{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int arr[][]= {{0,1,0,0,0,0},
                    {1,0,1,0,0,0},
                    {0,1,0,1,1,0},
                    {0,0,1,0,1,0},
                    {0,0,1,1,0,1},
                    {0,0,0,0,1,0}};
      int len = arr.length;
      System.out.print("a");
      dfss(arr,0);
   }
   
   public static void dfss(int[][] arr,int ind){
      int len = arr.length;
         for(int j = 0; j<len; j++){
            if(arr[ind][j]==1){
               System.out.print("  "+(char)(97+j));
               arr[j][ind]=0;
               for(int k=0; k<len;k++){
                 arr[k][j]=0;
                 arr[k][0]=0;
               }

               dfss(arr,j);
            }
            else
               continue;
         }
      
   }
   
}