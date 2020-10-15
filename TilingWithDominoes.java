

import java.util.Scanner;

public class TilingWithDominoes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.next());
		while(testCases-->0) {
			int n = Integer.parseInt(sc.next());
			int[][] a = new int[2][n+1];
			a[0][0]=1;a[1][0]=0;
			a[0][1]=0;a[1][1]=1;
			for(int i=2;i<=n;i++) {
				a[0][i] = a[0][i-2] + 2*(a[1][i-1]);
				a[1][i] = a[0][i-1] + a[1][i-2];
			}
			System.out.println("Result: "+a[0][n]);
		}
		sc.close();
	}

}
