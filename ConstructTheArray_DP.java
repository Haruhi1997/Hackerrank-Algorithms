import java.util.Scanner;

public class ConstructTheArray_DP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.next());
		while(testCases-->0) {
			int n = Integer.parseInt(sc.next());
			int k = Integer.parseInt(sc.next());
			int x = Integer.parseInt(sc.next());
			System.out.println("No of ways: "+countArray(n,k,x));
		}
		sc.close();
	}
	
	static long countArray(int n, int k, int x) {
		long ways = 0;
		long mod = (long) 1e9+7;
		//a[i] = array of length 'i+1' with element ending with x and starting with 1
		//b[i] = array of length 'i+1' with element not ending with x and starting with 1
		long[] a = new long[n];
		long[] b = new long[n];
		if(x==1) {
			a[0]=1;
			b[0]=0;
		}else {
			a[0]=0;
			b[0]=1;
		}
		for(int i=1;i<n;i++) {
			a[i]=(b[i-1])%mod;
			b[i]= (a[i-1]*(k-1) + b[i-1]*(k-2))%mod;
		}
		ways = a[a.length-1];
		return ways;
	}

}
