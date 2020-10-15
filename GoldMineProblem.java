

import java.util.Scanner;

public class GoldMineProblem {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int[][] m1 = new int[][] {
				{1,3,3},
				{2,1,4},
				{0,6,4}};
		goldMine(m1);
		int[][] m2 = new int[][] {
			{1,3,1,5},
			{2,2,4,1},
			{5,0,2,3},
			{0,6,1,2}
		};
		goldMine(m2);
		
		int[][] m3 = new int[][] {
			{10, 33, 13,15},
			{22, 21,04,1},
			{5,0,2,3},
			{0,6,14,2}
		};
		goldMine(m3);
	}
	
	public static void goldMine(int[][] m) {
		int row=m.length;
		int col=m[0].length;
		int[][] a = new int[row+2][col+1];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				a[i+1][j]=m[i][j];
			}
		}
		//print2Darray(a);
		for(int i=col-1;i>=0;i--) {
			for(int j=1;j<=row;j++) {
				int right = a[j][i+1];
				int rightUp = a[j-1][i+1];
				int rightDown = a[j+1][i+1];
				int value = a[j][i]+Math.max(Math.max(rightUp,rightDown), right);
				a[j][i]=value;
			}
		}
		int result=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			result = Math.max(result, a[i][0]);
		}
		System.out.println("Result: "+result);
		//print2Darray(a);
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
