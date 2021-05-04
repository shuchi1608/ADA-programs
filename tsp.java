import java.util.*;
public class tsp{
static ArrayList<Integer> combo = new ArrayList<Integer>();
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int arr[][] = {{0,10,15,20},
                     {5,0,9,10},
                     {6,13,0,12},
                     {8,8,9,0}};
      tspfunc(arr);
   }
   
   public static void tspfunc(int[][] arr){
      int len = arr.length;
      int start = 1;   //starting node
      String per ="";
      for(int i = 1; i<=len; i++){
         if(start!=i){
            per=per+i;                    //makes numbers to be permuted
         }
      }
      int l = per.length();
      permute(per,0,l-1);
      int x = combo.size();
      int[] paths = new int[x];
      for(int i = 0; i<x;i++){
         paths[i] = combo.get(i);        // stores all the possible paths found using permutation
      }
      int sum =0;
      int[] dist = new int[x];
      for(int i = 0; i<x; i++){
         sum = 0;
         for(int j = 0; j<l; j++){
            String path = paths[i]+"";
            char pr = path.charAt(j);
            int p = Character.getNumericValue(pr);      //we have path in the form of '234' so we extract char by char and find the sum of distances
            if(j==0){
               sum = sum+arr[start-1][p-1];
            }
            else if(j!=0 && j<l-1){
               String k = paths[i]+"";
               char ch = k.charAt(j-1);
               int m = Character.getNumericValue(ch);
               sum=sum+arr[m-1][p-1];
            }
            else if(j!=0 && j==l-1){
               String k = paths[i]+"";
               char ch = k.charAt(j-1);
               int m = Character.getNumericValue(ch);
               sum=sum+arr[m-1][p-1];
               sum = sum+arr[p-1][start-1];
            }
         }
         dist[i] = sum;       //stores the distance of all the possible routes
           
      }
      int ind = min(dist);  //finds the index of minimum distance stored in dist array
      System.out.print("\nThe shortest path is :"+start+""+paths[ind]+""+start+"\nThe distance of this path is :"+dist[ind]);

   }
   
   public static void permute(String str, int l, int r){
		if (l == r){
         String temp = str;
         combo.add(Integer.parseInt(temp));
      }   
		else{
			for (int i = l; i <= r; i++){
				str = swap(str,l,i);
				permute(str, l+1, r);
				str = swap(str,l,i);
			}
		}    
      
	}
   
	public static String swap(String a, int i, int j){
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
   
   public static int min (int [] arr1) {
       int index = 0;
       int min = arr1[index];

       for (int i=1; i<arr1.length; i++) {
           if (arr1[i] < min) {
               min = arr1[i];
               index = i;
           }
       }
       return index;
  }
}