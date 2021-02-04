package dp;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-->=0) {
			int n = Integer.parseInt(sc.next());
			int[] b = new int[n];
			for(int i=0;i<n;i++) {
				b[i]=Integer.parseInt(sc.next());
				b[i] -=1;
			}
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
	public static void partit(int[] b) {
		int n = b.length;
		int[] a = new int[n];
		for(int i=0;i<n;i++) {a[i]=1;}
		for(int i=0;i<n;i++) {
			int ind = b[i];
			a[ind] = a[i];
		}
		
	}
	
	
	
}
