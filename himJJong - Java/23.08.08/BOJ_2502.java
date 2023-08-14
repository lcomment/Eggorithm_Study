import java.io.BufferedReader;
import java.util.Scanner;

public class BOJ_2502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int bread = sc.nextInt();

        if(days == 3){
            int x = 1;
            int y = bread - x;

            System.out.println(x);
            System.out.println(y);
            System.exit(0);
        }

        int[] dp = new int[days+1];
        int[] dp2 = new int[days+1];

        dp[3] = 1;
        dp[4] = 1;

        dp2[3] = 1;
        dp2[4] = 2;

        for(int i=5; i<=days; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp2[i] = dp2[i-1] + dp2[i-2];
        }

        int x = 1;
        int y = 0;
        while(true){
            int tmp = bread - (dp[days]*x);
            if(tmp % dp2[days] == 0){
                y = tmp / dp2[days];
                break;
            }
            x++;
        }

        System.out.println(x);
        System.out.println(y);
    }
}
