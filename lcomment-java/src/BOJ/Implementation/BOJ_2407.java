package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_2407 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        BigInteger sum = BigInteger.ONE;
        BigInteger div = BigInteger.ONE;

        for(int i = 0; i<m; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(n-i)));
            div = div.multiply(new BigInteger(String.valueOf(i+1)));
        }

        System.out.println(sum.divide(div));
    }
}