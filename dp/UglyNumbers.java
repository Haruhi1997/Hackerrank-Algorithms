package dp;
 
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set; 

public class UglyNumbers { 
	
	static int getNthUglyNo(int n) 
	{ 
		int ugly[] = new int[n];  
		int i2 = 0, i3 = 0, i5 = 0; int next_multiple_of_2 = 2; int next_multiple_of_3 = 3; int next_multiple_of_5 = 5; 
		int next_ugly_no = 1; 
		ugly[0] = 1; 
		for(int i = 1; i < n; i++) 
		{ 
			next_ugly_no = Math.min(next_multiple_of_2, 
								Math.min(next_multiple_of_3, 
										next_multiple_of_5)); 
			ugly[i] = next_ugly_no; 
			if (next_ugly_no == next_multiple_of_2) 
			{ 
			i2 = i2+1; 
			next_multiple_of_2 = ugly[i2]*2; 
			} 
			if (next_ugly_no == next_multiple_of_3) 
			{ 
			i3 = i3+1; 
			next_multiple_of_3 = ugly[i3]*3; 
			} 
			if (next_ugly_no == next_multiple_of_5) 
			{ 
			i5 = i5+1; 
			next_multiple_of_5 = ugly[i5]*5; 
			} 
		} 
		return next_ugly_no; 
	} 
	public static int getMin(int[] a) {
		int minE=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			minE = Math.min(minE, a[i]);
		}
		return minE;
	}

	 public static void superUgly(int n, int[] primes, int k) {
		 int[] primeDoneTill = new int[primes.length];
		 int[] result = new int[n];
		 result[0]=1;
		 for(int i=1;i<n;i++) {
			 int min=Integer.MAX_VALUE;
			 for(int j=0;j<primes.length;j++) {
				 min = Math.min(min, primes[j]*result[primeDoneTill[j]]);
			 }
			 result[i]=min;
			 //Finding the index from which we picked min
			 for(int j=0;j<primes.length;j++) {
				 if(min==result[primeDoneTill[j]]*primes[j]) {
					 primeDoneTill[j]++;
				 }
			 }
		 }
		 System.out.println("Num: "+result[n-1]);
	 }
	 
	 static void printArr(int[] a) {
		 for(int i=0;i<a.length;i++) {
			 System.out.print(a[i]+" : ");
		 }
		 System.out.println();
	 }
	
	public static void main(String args[]) 
	{ 
		 superUgly(50
				 ,new int[]{2,3,5},2);
	} 
} 

 
