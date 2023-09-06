import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1780 {
    static int minusCount = 0;
    static int zeroCount = 0;
    static int plusCount = 0;
    static int[][] board;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++){
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        partition(0,0,N);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(plusCount);
    }

    private static void partition(int row, int col, int size) {
        if(colorCheck(row,col,size)){
            if(board[row][col] == 0){
                zeroCount++;
            }
            else if(board[row][col] == 1){
                plusCount++;
            }
            else{
                minusCount++;
            }
            return;
        }
        int newSize = size/3;

        partition(row, col, newSize);								// 왼쪽 위
        partition(row, col + newSize, newSize);						// 중앙 위
        partition(row, col + 2 * newSize, newSize);					// 오른쪽 위

        partition(row + newSize, col, newSize);						// 왼쪽 중간
        partition(row + newSize, col + newSize, newSize);			// 중앙 중간
        partition(row + newSize, col + 2 * newSize, newSize);		// 오른쪽 중간

        partition(row + 2 * newSize, col, newSize);					// 왼쪽 아래
        partition(row + 2 * newSize, col + newSize, newSize);		// 중앙 아래
        partition(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    private static boolean colorCheck(int row, int col, int size) {
        int tmp = board[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(board[i][j] != tmp){
                    return false;
                }
            }
        }
        return true;
    }
}