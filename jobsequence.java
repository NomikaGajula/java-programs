package DAA;
import java.util.*;
class jobseq{
	String no;
	int dead,profit;
	jobseq(String no,int dead,int profit){
		this.no=no;
		this.dead=dead;
		this.profit=profit;
	}
}
public class jobsequence {
	static void printjobs(ArrayList<jobseq> A,int t) {
		int n=A.size();
		Collections.sort(A,(a,b)-> b.profit - a.profit);
		boolean result[]=new boolean[t];
		
		String job[]=new String[t];
		for(int i=0;i<n;i++) {
			for(int j=Math.min(t-1, A.get(i).dead);j>=0;j--) {
				if(result[j]==false) {
					result[j]=true;
					job[j]=A.get(i).no;
					break;
				}
			}
			for(String c: job) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList<jobseq> A=new ArrayList<jobseq>();
       Scanner s=new Scanner(System.in);
       System.out.println("enter no of jobs: ");
       int n=s.nextInt();
       for(int i=0;i<n;i++) {
    	   String no=s.next();
    	   int dead=s.nextInt();
    	   int profit=s.nextInt();
    	   jobseq N=new jobseq(no,dead,profit);
    	   A.add(N);
       }
       printjobs(A,3);
	}

}
