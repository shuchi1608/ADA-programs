import java.util.*;
// Java program to solve fractional Knapsack Problem
import java.util.Arrays;
import java.util.Comparator;

// Greedy approach
public class FractionalKnapSack {
	// function to get maximum value
	private static double getMaxValue(int[] wt, int[] val,
									int capacity)
	{
		ItemValue[] iVal = new ItemValue[wt.length];

		for (int i = 0; i < wt.length; i++) {
			iVal[i] = new ItemValue(wt[i], val[i], i);
		}

		// sorting items by value;
		Arrays.sort(iVal, new Comparator<ItemValue>() {
			@Override
			public int compare(ItemValue o1, ItemValue o2)
			{
				return o2.cost.compareTo(o1.cost);
			}
		});

		double totalValue = 0d;

		for (ItemValue i : iVal) {

			int curWt = (int)i.wt;
			int curVal = (int)i.val;

			if (capacity - curWt >= 0) {
				// this weight can be picked while
				capacity = capacity - curWt;
				totalValue += curVal;
			}
			else {
				// item cant be picked whole
				double fraction
					= ((double)capacity / (double)curWt);
				totalValue += (curVal * fraction);
				capacity
					= (int)(capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}

	// item value class
	static class ItemValue {
		Double cost;
		double wt, val, ind;

		// item value function
		public ItemValue(int wt, int val, int ind)
		{
			this.wt = wt;
			this.val = val;
			this.ind = ind;
			cost = new Double((double)val / (double)wt);
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		int[] wt = {10,12,14,7,8};
		int[] val = {25,49,17,54,60};
		int capacity = 20;

		double maxValue = getMaxValue(wt, val, capacity);

		// Function call
		System.out.println("Maximum value we can obtain = "
						+ maxValue);
	}
}

// 	{ 
// 		int[] val = new int[] {25,49,17,54,60};
      // Random rand = new Random();
//       for( int i = 0; i<10 ; i++){
//          val[i] = rand.nextInt(1000-100) + 100;
//       }
//       int[] wt = new int[] {10,12,14,7,8};
      // for( int i = 0; i<10 ; i++){
//          wt[i] = rand.nextInt(100);
//       }