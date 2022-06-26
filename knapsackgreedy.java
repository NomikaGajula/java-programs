package DAA;
import java.util.*;

public class knapsackgreedy {

public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the no of elements in the array");
        int n=s.nextInt();
        int value[]=new int[n];
        int weight[]=new int[n];
        double v_w[]=new double[n];
        System.out.println("Enter weights and corresponding values of the weights : ");
        for(int i=0;i<n;i++) {
        weight[i]=s.nextInt();
        value[i]=s.nextInt();
        v_w[i]=1.0*value[i]/weight[i];
        }
        System.out.println("The weights, it's values and v/w ratio before rearranging are \n weight values are ");
        for(int i=0;i<n;i++) {
        System.out.print(weight[i]+" ");
        }
        System.out.println();
        System.out.println("The values are ");
        for(int i=0;i<n;i++) {
        System.out.print(value[i]+" ");
        }
        System.out.println("\nThe v/w ratio values are ");
        for(int i=0;i<n;i++) {
        System.out.print(v_w[i]+" ");
        }
        System.out.println();
        System.out.println("After rearraging the array values are \nweights values are ");
        for(int i=0;i<n-1;i++) {
        for(int j=0;j<n-i-1;j++) {
        if(v_w[j]<v_w[j+1]) {
        double temp=v_w[j];
        v_w[j]=v_w[j+1];
        v_w[j+ 1]=temp;
        int temp1=weight[j];
        weight[j]=weight[j+1];
        weight[j+1]=temp1;
        int temp2=value[j];
        value[j]=value[j+1];
        value[j+1]=temp2;
        }
        }
        }
        for(int i=0;i<n;i++) {
        System.out.print(weight[i]+" ");
        }
        System.out.println();
        System.out.println("The values are ");
        for(int i=0;i<n;i++) {
        System.out.print(value[i]+" ");
        }
        System.out.println();
        System.out.println("The v/w ratio value are ");
        for(int i=0;i<n;i++)
        {
        System.out.print(v_w[i]+" ");
        }
        System.out.println();
       
double sum=0;
System.out.println("Enter the weight to be filled up");
int N=s.nextInt();
int i=0;
long st=System.nanoTime();
while(N>0) {
if(weight[i]<N) {
sum+=value[i];
N-=weight[i];
i++;
}
else {
double x1=N*value[i];
int x2=weight[i];
sum+=x1/x2;
N=0;
}
}
long en=System.nanoTime();
System.out.println("The total profit is "+sum+"\nIt's nano time is "+(en-st));
}
}
