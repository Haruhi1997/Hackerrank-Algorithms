package dp;

import java.util.Scanner;

public class PartitionProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-->=0) {
			int n = Integer.parseInt(sc.next());
			int[] a = new int[n];
			for(int i=0;i<n;i++) {
				a[i]=Integer.parseInt(sc.next());
			}
			if(allEqual(a)) {
				if(n%2==0) {
					int res = (n*a[0])/2;
					System.out.println(res);
				}else {
					int res = (n*a[0])/2;
					res+=a[0];
					System.out.println(res);
				}
			}
			partit(a);
		}
		//int[] arr = new int[] {2,3,3,4};
		sc.close();
	}
	
	public static boolean allEqual(int[] a) {
		for(int i=1;i<a.length;i++) {
			if(a[i]!=a[i-1]) {
				return false;
			}
		}
		return true;
	}
	public static void partit(int[] a) {
		int n = a.length;
		int su = 0;
		for(int i=0;i<n;i++) {
			su+=a[i];
		}
		boolean[][] dp = new boolean[n+1][su+1];
		//dp[i][j] -- i is the coin[i-1] 
		//j-- sum
		//dp[i][j]=true if sum j can be achieved
		//using coins from coins[0]to coins[i-1]
		for(int i=1;i<dp[0].length;i++) {
			//With 0 coins no sum is possible to achieve
			dp[0][i]=false;
		}
		for(int i=0;i<=n;i++) {
			dp[i][0]=true;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				
				//Exclude val at i
				dp[i][j]=dp[i-1][j];
				
				//Include val at i
				if(j>=a[i-1]) {
					dp[i][j] |= dp[i-1][j-a[i-1]];
				}
				
			}
		}
		
		//print2DArray(dp);
		int mindiff=0;
		int subsum=0;
		// Check if sum/2 to 0 any sum possible
		for(int j=su/2;j>=0;j--) {
			if(dp[n][j]==true) {
				mindiff = su - 2*j;
				subsum=j;
				break;
			}
		}
		//System.out.println("Min diff: "+mindiff);
		int result = mindiff+subsum;
		System.out.println(result);
	}
	
	
	
	public static void print2DArray(boolean[][] dp) {
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(dp[i][j]) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

}
