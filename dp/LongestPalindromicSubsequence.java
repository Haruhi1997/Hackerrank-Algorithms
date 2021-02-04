package dp;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String s = "GEEKSFORGEEKS";
		lps(s);
	}
	
	public static void lps(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++) {
			//Each letter can be a palindrome
			dp[i][i]=1;
		}
		
		//Considering palindromes of length 2 o& above
		for(int len=2;len<n;len++) {
			for(int i=0;i<n-len+1;i++) {
				//Rear end of palindrome
				int j = i+len-1;
				if(s.charAt(i)==s.charAt(j)) {
					if(len==2) {
						dp[i][j]=2;
					}else {
						dp[i][j] = dp[i+1][j-1]+2;
					}
				}else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		//dp[0][n-1] represent max length of palindrome with start 
		//index 0 and end index n-1
		System.out.println("Longest Palindromic subsequence: "+dp[0][n-1]);
		
	}

}
