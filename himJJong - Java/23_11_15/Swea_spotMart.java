import java.io.*;
import java.util.*;

class Swea_spotMart{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= test; test_case++) {
            st = new StringTokenizer(br.readLine());
            int snack = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            int[] snacks = new int[snack];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<snack; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(snacks);

            int left = 0;
            int right = snack-1;
            int max = Integer.MIN_VALUE;

            while(left < right) {
                int sum = snacks[left] + snacks[right];

                if(sum <= limit) {
                    max = Math.max(max, sum);
                    left++;
                }
                else {
                    right--;
                }
            }
            if(max == Integer.MIN_VALUE) {
                System.out.println("#"+test_case+" "+ "-1");
            }
            else	System.out.println("#"+test_case+" "+max);
        }
    }
}
