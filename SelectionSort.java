import java.util.*;
class SelectionSort{ 
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
        selectionSort(arr); 
        System.out.println("Sorted array"); 
        for(int i=0; i<l ; i++){
            System.out.print(arr[i]+"  ");
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
} 


















