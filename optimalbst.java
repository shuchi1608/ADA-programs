import java.util.*;
class optimalbst{
   public static void main(String args[]){
      ArrayList<Integer> root = new ArrayList<Integer>();
      System.out.print("Enter number of nodes  in a tree :  ");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      //float[] fre = new float[n];
      float[][] arr = new float[n+1][n+1];
      System.out.println("Enter frequency of each nodes :");
      for(int i =0; i<n; i++){
         System.out.print((i+1)+"  =  ");
         //fre[i] = sc.nextFloat();
         arr[i+1][i+1] = sc.nextFloat();
      }
      for(int i = 2; i <n+1 ; i++){
         for(int j = 1; j<n+1; j++){
            if(i+j-1 < n+1){
               System.out.println(j+"  "+(i+j-1));
               arr[j][i+j-1] = min(arr,j,i+j-1,root);
            }
         }
      }
      System.out.println(root);
   }
   public static float min(float[][] arr, int i, int j, ArrayList<Integer> root){
      float summ = 10;
      int r = 0;
      for(int k = i; k <= j ; k++){
         if(k+1<arr.length){
            if(summ >=( arr[i][k-1] + arr[k+1][j] + sum(arr,i,j))){
               summ = arr[i][k-1] + arr[k+1][j] + sum(arr,i,j);
               r=k;
            }
         }
         else{
            if(summ >=( arr[i][k-1] + arr[0][0] + sum(arr,i,j))){
               summ = arr[i][k-1] + arr[0][0] + sum(arr,i,j);
               r=k;
            }
         }
      }
      root.add(r);
      return summ;
   }
   public static float sum(float[][] arr, int i , int j){
      float summ1 = 0;
      for(int k = i; k<=j ; k++){
         summ1 = summ1+arr[k][k];
      }
      return summ1;
   }
}