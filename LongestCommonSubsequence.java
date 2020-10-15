

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.next());
		while(testCases-->0) {
			String a = sc.next();
			String b = sc.next();
			int m = a.length();
			int n = b.length();
			int[][] lcs = new int[m+1][n+1];
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=m;i++) {
				for(int j=1;j<=n;j++) {
					//lcs[i-1][j]----> without char from b
					//lcs[i][j-1]----> Without char from a
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
					if(a.charAt(i-1)==b.charAt(j-1)) {
						//Accounted for duplicates
						lcs[i][j] = lcs[i-1][j-1]+1;
						if(lcs[i][j]>lcs[i][j-1] && lcs[i][j]>lcs[i-1][j]) {
						sb.append(a.charAt(i-1));
						}
					}
				}
			}
			System.out.println("LCS for "+a+" and "+b+" is "+sb.toString()+" and of length "+lcs[m][n]);
		}
		sc.close();

	}

}
