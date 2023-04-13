import java.util.Scanner;

public class codeTree_Dp {
    public static final int MAX_N = 1000;

    // 변수 선언
    public static int n;
    public static int[][] num = new int[MAX_N][MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static void initialize() {
        // 시작점의 경우 dp[0][n - 1] = num[0][n - 1]으로 초기값을 설정해줍니다
        dp[0][n - 1] = num[0][n - 1];

        // 최우측 열의 초기값을 설정해줍니다.
        for(int i = 1; i < n; i++)
            dp[i][n - 1] = dp[i - 1][n - 1] + num[i][n - 1];

        // 최상단 행의 초기값을 설정해줍니다.
        for(int j = n - 2; j >= 0; j--)
            dp[0][j] = dp[0][j + 1] + num[0][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                num[i][j] = sc.nextInt();

        // 초기값 설정
        initialize();

        // 탐색하는 위치의 위에 값과 우측 값 중에 작은 값에
        // 해당 위치의 숫자를 더해줍니다.
        for(int i = 1; i < n; i++)
            for(int j = n - 2; j >= 0; j--)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + num[i][j];

        System.out.print(dp[n - 1][0]);
    }
}