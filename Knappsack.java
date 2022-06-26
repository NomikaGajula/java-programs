package DAA;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Main{
	int wt,pro;
	Main(int wt,int pro){
		this.wt=wt;
		this.pro=pro;
	}
}
public class Knappsack {
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
	static int knapSack(int W, ArrayList<Main> obj, int n)
	{
		// Base Case
		if (n == 0 || W == 0)
			return 0;

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		if (obj.get(n-1).wt > W)
			return knapSack(W, obj, n - 1);

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		else
			return max(obj.get(n-1).pro+ knapSack(W -obj.get(n-1).wt, obj, n - 1),knapSack(W, obj, n - 1));
	}

	// Driver code
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the value of the no of weights : ");
		int n=s.nextInt();
		ArrayList<Main> obj=new ArrayList<Main>();
		
		for(int i=0;i<n;i++) {
			obj.add(new Main(s.nextInt(),s.nextInt()));
		}
				Collections.sort(obj,(a,b)->a.wt-b.wt);
				for(int i=0;i<n;i++) {
					System.out.println(obj.get(i).wt+" "+obj.get(i).pro);
				}
		System.out.println("Enter the total weight ; ");
		int W = s.nextInt();
		
		System.out.println(knapSack(W,obj, n));
	}
}
/*This code is contributed by Rajat Mishra */
