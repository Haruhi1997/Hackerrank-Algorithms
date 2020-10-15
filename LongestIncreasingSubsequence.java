

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.next());
		while(testCases-->0) {
			System.out.println("testcase"+testCases);
			
			int n = Integer.parseInt(sc.next());
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(sc.next());
			}
			findLIS(arr,arr.length);
			findLMaxSum(arr,arr.length);
		}
	}
	
	public static void findLIS(int[] a,int n) {
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(lis[i]>lis[j] && lis[i]<lis[j]+1) {
					lis[i]=lis[j]+1;
				}
			}
		}
		
		int maxsoFar= Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			maxsoFar = Math.max(maxsoFar, lis[i]);
		}
		
		System.out.println("Length of LIS: "+maxsoFar);
	}
	
	public static void findLMaxSum(int[] a,int n) {
		int[] lis = new int[n];
		for(int i=0;i<n;i++) {lis[i]=a[i];}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(a[i]>a[j] && lis[i]<lis[j]+a[i]) {
					lis[i]=lis[j]+a[i];
				}
			}
		}
		
		int maxsoFar= Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			maxsoFar = Math.max(maxsoFar, lis[i]);
		}
		
		System.out.println("Length of LIS: "+maxsoFar);
	}

}