class pro_goSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        int div = 1000000007;
        dp[1][1] = 1;

        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];

            dp[x][y] = -1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                if(!(i==1 && j==1)){
                    int left = 0;
                    int right = 0;

                    if(j > 1){
                        left = dp[i][j-1];
                    }
                    if(i > 1){
                        right = dp[i-1][j];
                    }
                    dp[i][j] = (left+right) % div;
                }
            }
        }
        return dp[n][m];
    }
}