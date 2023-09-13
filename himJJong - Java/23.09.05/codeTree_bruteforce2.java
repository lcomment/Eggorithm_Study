import java.util.Scanner;

public class codeTree_bruteforce2 {
    public static final int MAX_NUM = 200;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    public static int[][][] shapes = new int[][][]{
                    {{1, 1, 0},
                    {1, 0, 0},
                    {0, 0, 0}},

                    {{1, 1, 0},
                    {0, 1, 0},
                    {0, 0, 0}},

                    {{1, 0, 0},
                    {1, 1, 0},
                    {0, 0, 0}},

                    {{0, 1, 0},
                    {1, 1, 0},
                    {0, 0, 0}},

                    {{1, 1, 1},
                    {0, 0, 0},
                    {0, 0, 0}},

                    {{1, 0, 0},
                    {1, 0, 0},
                    {1, 0, 0}},
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int ans = 0;

        // 격자의 각 위치에 대하여 탐색하여줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                ans = Math.max(ans, getMaxSum(i, j));

        System.out.print(ans);
    }

    public static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for(int i = 0; i < 6; i++) {    // 만들어 놓은 모양
            boolean isPossible = true;
            int sum = 0;
            for(int dx = 0; dx < 3; dx++)
                for(int dy = 0; dy < 3; dy++) {
                    if(shapes[i][dx][dy] == 0) {    // 만들어놓은게 0이면 continue
                        continue;
                    }

                    if(x + dx >= n || y + dy >= m){ // 범위가 벗어나면 false;
                        isPossible = false;
                    }
                    else sum += grid[x + dx][y + dy];   // 위 2가지에 해당하지 않는다면 sum += grid[][]
                }
            if(isPossible)
                maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}