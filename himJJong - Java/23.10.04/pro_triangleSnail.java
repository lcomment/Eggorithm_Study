import java.util.Arrays;

class pro_triangleSnail {
    public static void main(String[] args) {
        int n = 5;
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                }
                else if (i % 3 == 1) {
                    y++;
                }
                else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}