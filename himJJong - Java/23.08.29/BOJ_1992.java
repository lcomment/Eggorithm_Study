import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1992 {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for(int i=0; i<N; i++){
            board[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        partition(0,0,N);
        System.out.println(sb);
    }

    private static void partition(int row, int col, int size) {
        if(checkNum(row,col,size)){
            if(board[row][col] == 1){
                sb.append("1");
            }
            else sb.append("0");
            return;
        }
        int newSize = size/2;
        sb.append("(");
        partition(row,col,newSize);
        partition(row,col+newSize,newSize);
        partition(row+newSize,col,newSize);
        partition(row+newSize,col+newSize,newSize);
        sb.append(")");
    }

    private static boolean checkNum(int row, int col, int size) {
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
