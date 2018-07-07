import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Alternating_characters {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
 
    	Scanner sc=new Scanner(System.in);
    	int t=sc.nextInt();
    	for(int i1=0;i1<t;i1++){
    		String s=sc.next();
    		char[] c=s.toCharArray();
    		int cnt=0;
    		for(int i=0;i<s.length()-1;i++){
    			if(c[i]==c[i+1]){cnt++;}    			
    			
    		}
    		System.out.println(cnt);
    	}
    }
}
