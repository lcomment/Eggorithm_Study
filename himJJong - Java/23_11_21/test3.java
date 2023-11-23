class test3 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0}, {0,1,1,0,1}, {0,0,1,0,1}, {1,1,1,0,1}};
        System.out.println(findLongestPerimeter(grid));
    }
    public static int findLongestPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxPerimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int perimeter = dfs(grid, i, j, rows, cols);
                    maxPerimeter = Math.max(maxPerimeter, perimeter);
                }
            }
        }

        return maxPerimeter;
    }

    // DFS를 사용하여 각 영역의 테두리를 찾고 테두리의 1의 개수를 반환하는 함수
    private static int dfs(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return 1; // 테두리를 벗어나거나 0인 경우
        }

        if (grid[i][j] == -1) {
            return 0; // 이미 방문한 곳
        }

        grid[i][j] = -1; // 방문한 위치는 -1로 표시하여 다시 방문하지 않도록 함

        int perimeter = 0;
        perimeter += dfs(grid, i - 1, j, rows, cols); // 위쪽
        perimeter += dfs(grid, i + 1, j, rows, cols); // 아래쪽
        perimeter += dfs(grid, i, j - 1, rows, cols); // 왼쪽
        perimeter += dfs(grid, i, j + 1, rows, cols); // 오른쪽

        // 테두리의 1의 개수를 반환
        return perimeter;
    }
}