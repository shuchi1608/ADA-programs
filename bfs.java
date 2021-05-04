import java.util.*;
public class bfs{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int arr[][]= {{0,1,0,0,0,0},
                    {1,0,1,0,0,0},
                    {0,1,0,1,1,0},
                    {0,0,1,0,1,0},
                    {0,0,1,1,0,1},
                    {0,0,0,0,1,0}};
      int len = arr.length;
      int final_arr[] = new int[len];
      final_arr[0] = 1;
      int l =1;
      for(int i=0; i<len;i++){
         for(int j=0; j<len;j++){
            if(arr[i][j]==1){
              final_arr[l] = j+1;
              l++;
              arr[j][i]=0;
              for(int k=i; k<len;k++){
               arr[k][j]=0;
              }
            }
            else{
               continue;
            }
         }
      }
      for(int i = 0; i<final_arr.length; i++){
         System.out.print((char)(96+final_arr[i])+"  ");
      }
   }
   
}