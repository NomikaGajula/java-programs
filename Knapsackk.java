package DAA;

import java.util.Scanner;

public class Knapsackk {


/* A Naive recursive implementation
of 0-1 Knapsack problem */


	// A utility function that returns
	// maximum of two integers
	static int max(int a, int b)
	{
	return (a > b) ? a : b;
	}

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	static int knapSack(int W, int wt[], int val[], int n)
	{
		// Base Case
		if (n == 0 || W == 0)
			return 0;

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		if (wt[n - 1] > W)
			return knapSack(W, wt, val, n - 1);

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		else
			return max(val[n - 1]
					+ knapSack(W - wt[n - 1], wt,
								val, n - 1),
					knapSack(W, wt, val, n - 1));
	}

	// Driver code
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the value of the no of weights : ");
		int n=s.nextInt();
		int val[] = new int[n];
		System.out.println("Enter the value profits : ");
		for(int i=0;i<n;i++) {
			val[i]=s.nextInt();
		}
		int wt[] = new int[n]; 
		System.out.println("enter the weight values : ");
		for(int i=0;i<n;i++) {
			wt[i]=s.nextInt();
		}int max=wt[0];
		for(int i=0;i<n-1;i++) {
			for(int j=i;j<n-1-i;j++) {
				if(wt[j+1]<wt[j]) {
					int temp=wt[j+1];
					wt[j+1]=wt[j];
					wt[j]=temp;
					temp=val[j+1];
					val[j+1]=val[j];
					val[j]=temp;
				}
			}
		}
		System.out.println("Enter the total weight ; ");
		int W = s.nextInt();
		
		System.out.println(knapSack(W, wt, val, n));
	}
}
/*This code is contributed by Rajat Mishra */
