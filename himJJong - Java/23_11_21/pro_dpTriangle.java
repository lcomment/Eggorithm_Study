class pro_dpTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;

        int row = triangle.length;
        int col = triangle.length;

        int[][] dp = new int[row][col];
        int max = Integer.MIN_VALUE;

        dp[0][0] = triangle[0][0];
        for(int i=1; i<row; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
        }
        for(int i=1; i<row; i++){
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }

        for(int i=2; i<row; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                if(i==row-1){
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        max = Math.max(dp[row-1][row-1],Math.max(max, dp[row-1][0]));
        return max;
    }
}