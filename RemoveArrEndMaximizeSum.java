

import java.util.Scanner;

public class RemoveArrEndMaximizeSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.next());
		while(testCases-->0) {
			int n = Integer.parseInt(sc.next());
			int[] a = new int[n];
			for(int i=0;i<n;i++) {
				a[i]=Integer.parseInt(sc.next());
			}
			int[][] dp = new int[n+1][n+1];
			long start = System.currentTimeMillis();
			int maxS = maxSum(dp,a,0,n-1,1);
			long end = System.currentTimeMillis();
			System.out.println(maxS);
			System.out.println("Execution time: "+(end-start)+" milliseconds");
		}
		sc.close();
	}
	
	public static int maxSum (int[][] dp, int[] a,int start, int end, int turn) {
		if(start==end) {
			return a[start]*turn;
		}
		//dp[i][j]--represents max sum of elements from start-end
		if(dp[start][end]!=0) {
			System.out.println("Already there for "+start+" : "+end);
			return dp[start][end];
		}
		dp[start][end] = Math.max(a[start]*turn + maxSum(dp,a,start+1,end,turn+1) , a[end]*turn + maxSum(dp,a,start,end-1,turn+1));
		
		
		return dp[start][end];
	}

}
