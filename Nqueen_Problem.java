import java.util.*;
public class Nqueen_Problem{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the size of matrix:");
      int n = sc.nextInt();
      int[][] arr = new int[n][n];
      if(n_Queen(arr,0,n)){
         for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
            if(arr[i][j] == 1) System.out.print(j+" ");;
            }
            System.out.println();
         }
      }
   }
   
   public static boolean is_safe(int[][] arr, int row, int col, int N){  
		int i, j;
		for (i = 0; i < col; i++)
			if (arr[row][i] == 1) return false;
            
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (arr[i][j] == 1) return false;
         
		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (arr[i][j] == 1) return false;
         
      return true;
   }
   
   public static boolean n_Queen(int[][] arr, int col, int N){
      if (col >= N)
	   	return true;

		for (int i = 0; i < N; i++){
			if(is_safe(arr, i, col,N)){
				arr[i][col] = 1;
				if (n_Queen(arr, col + 1,N) == true) return true;
            
				arr[i][col] = 0; 
			}
		}
		return false;
   }
  
}