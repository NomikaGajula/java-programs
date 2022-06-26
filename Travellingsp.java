package DAA;

import java.util.*;
public class Travellingsp {

public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the no of cities: ");
        int n=s.nextInt();
        int a[][]=new int[n][n];
        System.out.println("Enter the no of edges: ");
        int ed=s.nextInt();
        /*for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
         a[i][j]=0;
        }
        }*/
        for(int i=0;i<ed;i++) {

        int A=s.nextInt();
            int B=s.nextInt();
            int c=s.nextInt();
            a[A-1][B-1]=c;
            a[B-1][A-1]=c;
        }
        for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
        System.out.print(a[i][j]+" ");
        }System.out.println();
        }
        System.out.print("select one vertex from the following : ");
int v=s.nextInt();
        int cost=travel(a,v);
        System.out.println("\nThe total cost to travel is "+cost);
}
    static int travel(int a[][],int v) {
    int n=a.length;
    int visited[]=new int[n];
    for(int i=0;i<n;i++)
    visited[i]=0;
    visited[v-1]=1;
    v=v-1;
    int c=1,sum=0,min = 0;
    int k=-1;
    while(c<=n) {
    	if(c==n)
        	visited[0]=0;
    for(int i=0;i<n;i++) {
    if(a[v][i]!=0&&visited[i]==0) {
    min=a[v][i];
    //System.out.println(c+"    "+"k"+"    "+min);
    break;
    }
    }
    for(int i=0;i<n;i++) {
    if(a[v][i]<=min&&visited[i]==0&&a[v][i]!=0) {
    min=a[v][i];
   // System.out.println("K value"+i+"   "+min);
    k=i;
    }  }
    visited[v]=1;
    c++;
    sum+=min;
    System.out.println((v+1));
    //System.out.println(v+"   "+min);
    v=k;
    }
  return sum;
    }
}