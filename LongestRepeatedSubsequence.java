

import java.util.Scanner;

public class LongestRepeatedSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.next());
		while(testCases-->0) {
			String s = sc.next();
			//"aabb"->"ab"
			int n = s.length();
			//Modification of LCS with two strings as same string but same characters shouldn't be on same index.
			
			longestRepeatedSequence(s,n);
		}

	}
	
	public static void longestRepeatedSequence(String s, int n) {
		int[][] a = new int[n+1][n+1];
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(i-1)==s.charAt(j-1) && i!=j) {
					a[i][j]=1+a[i-1][j-1];
				}else {
					a[i][j]=Math.max(a[i][j-1], a[i-1][j]);
				}
			}
		}
		System.out.println(a[n][n]);
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++) {
//				System.out.print(a[i][j]+", ");
//			}
//			System.out.println();
//		}
		int i=n,j=n;
		
		while(i>0 && j>0 ) {
				if(a[i][j]==a[i-1][j-1]+1) {					
					sb.append(s.charAt(i-1));
					i--;j--;
				}else if (a[i][j]==a[i-1][j]){
					//It got the value from the row above while filling
					i--;
				}else {
					//Current cell got value from left col while filling
					j--;
				}
		}
		System.out.println(sb.toString());
		
	}

}
