import java.util.ArrayList;
import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		sieve(n);
		sc.close();
	}
	
	static int MAX_SIZE = 1000005;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	//Find first n prime numbers starting from 2
	public static void sieve(int n) {
		boolean[] isPrime = new boolean[MAX_SIZE];
		
		for(int i=0;i<MAX_SIZE;i++) {
			isPrime[i]=true;
		}
		
		for(int p=2;p*p<MAX_SIZE;p++) {
			if(isPrime[p]==true) {
				for(int )
			}
		}
		
	}

}
