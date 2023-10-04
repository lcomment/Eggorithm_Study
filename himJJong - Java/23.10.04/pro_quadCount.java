import java.io.*;

class pro_quadCount {
    static int zero = 0;
    static int one = 0;
    public int[] solution(int[][] arr)throws IOException {
        int[] answer = new int[2];

        partition(0,0,arr.length,arr);
        answer[0] = zero;
        answer[1] = one;

        return answer;
    }
    private static void partition(int row, int col, int size,int[][] arr){
        if(numberCheck(row,col,size,arr)){
            if(arr[row][col] == 0){
                zero++;
            }
            else{
                one++;
            }
            return;
        }

        int newSize = size/2;

        partition(row, col, newSize, arr);
        partition(row, col + newSize, newSize, arr);
        partition(row+newSize, col, newSize, arr);
        partition(row+newSize, col+newSize, newSize, arr);
    }

    private static boolean numberCheck(int row, int col, int size, int[][] arr){
        int tmp = arr[row][col];
        int zeroData = 0;
        int oneData = 0;

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(arr[i][j] == 0)  zeroData++;
                else    oneData++;
            }
        }

        if(zeroData == 0 || oneData == 0){
            return true;
        }
        return false;
    }
}