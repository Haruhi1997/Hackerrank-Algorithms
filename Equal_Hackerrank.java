import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Equal_Hackerrank {

    // Complete the equal function below.
    static int equal(int[] a) {
        Arrays.sort(a);
           
            int n = a.length;
            //Concept of baselines arise in case of n=4, where adding 1 invovles 1 operation with 5 coin than subtracting 2 twice resulting in 2 operations with two 2 coins.Similarly with the case of 3, adding 2 as base would result in 1 operation wuth 5 coin than 2 operations with (1,2) coins.
            int ways = Integer.MAX_VALUE;
            for(int base=0;base<=2;base++){
                
                int curr=0;  
                for(int i=0;i<n;i++) {
                    int delta = a[i]-a[0]+base;
                    curr += (int)delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;                   
                }
                System.out.println(curr);
                ways = Math.min(ways,curr);
            }
        return ways;
    }

    public static int coinChange(int n) {
        if(n<=5) {
            if(n==5) {return 1;}
            if(n==4) {return 2;}
            if(n==3) {return 2;}
            if(n==2) {return 1;}
            if(n==1) {return 1;}
            if(n==0) {return 0;}
        }
        int divi = n/5;
        n = n - (divi*5);
        int divi2 = n/2;
        n = n - (divi2*2);
        int divi3 = n;
        return divi+divi2+divi3;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
