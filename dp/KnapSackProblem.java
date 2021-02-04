package dp;

public class KnapSackProblem {

	public static void main(String[] args) {
		int val[] = new int[] {60,100,120};
		int wt[] = new int[] {10, 20, 30};
		int W = 50;
		knapsack(val,wt,W);
	}
	
	public static void knapsack(int[] v, int[] w, int cap) {
		int[][] dp = new int[w.length+1][cap+1];
		for(int i=1;i<=w.length;i++) {
			for(int j=1;j<=cap;j++) {
				int consider = Integer.MIN_VALUE;
				//Considering stone j
				if(j>=w[i-1]) {
					System.out.println(i+":"+j+":"+(j-w[i-1]));
					consider = v[i-1]+dp[i-1][j-w[i-1]];
				}
				//Not considering stone j
				int notconsider = dp[i-1][j];
				dp[i][j]=Math.max(consider, notconsider);
			}
		}
		System.out.println(dp[v.length][cap]);
	}

}
