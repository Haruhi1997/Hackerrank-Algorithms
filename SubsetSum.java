

import java.util.Arrays;

public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = {4,1,10,12,5,2};
		int sum = 9;
		Arrays.sort(arr);
		subsetSum(arr,sum);
		int[] a1= {1,2,8,5};
		int s1=4;
		Arrays.sort(a1);
		subsetSum(a1,s1);

	}
	
	public static void subsetSum(int[] a,int n) {
		int[][] m = new int[2][n+1];
		int curr =1;
		int prev =0;
		m[0][0]=1;
		for(int j=0;j<a.length;j++) {
			for(int i=0;i<=n;i++) {
				m[curr][i]= m[prev][i];
				if(i>=a[j]) {
					m[curr][i]+=m[prev][i-a[j]];
				}
				 
			}
			int temp = curr;
			curr=prev;
			prev=temp;
		}
		System.out.println(m[prev][n]);
		//System.out.println(m[curr][n-1]);
		print2Darray(m);
	}
	
	public static void print2Darray(int[][] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
