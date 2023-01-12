import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr;
        int T;
 
        T = Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++) {
            arr = new int[9][9];
            for(int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(isDuplicationColumns(arr)) {
                System.out.println("#" + test_case + " 0");
            } else if(isDuplicationRows(arr)) {
                System.out.println("#" + test_case + " 0");
            }
            else if(isDuplicationThreeArrays(arr)) {
                System.out.println("#" + test_case + " 0");
            } else {
                System.out.println("#" + test_case + " 1");
            }
        }
    }
    public static boolean isDuplicationRows(int[][] arr) {
        boolean[] visited;

        for(int i = 0; i < 9; i ++) {
            visited = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if (visited[arr[j][i]]) {
                    return true;
                }
                visited[arr[j][i]] = true;
            }
        }
        return false;
    }
 
    public static boolean isDuplicationColumns(int[][] arr) {
        boolean[] visited;

        for(int i = 0; i < 9; i ++) {
            visited = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if (visited[arr[i][j]]) {
                    return true;
                }
                visited[arr[i][j]] = true;
            }
        }
        return false;
    }
 
    public static boolean isDuplicationThreeArrays(int[][] arr) {
        for(int i = 0; i < 9; i = i + 3) {
            for(int j = 0; j < 9; j = j + 3) {
                if(i + 3 >= 9 || j + 3 >= 9) {
                    continue;
                }
                if(checkThreeArrays(arr, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
 
    public static boolean checkThreeArrays(int[][] arr, int n, int m) {
        boolean[] visited = new boolean[10];
        
        for(int i = n; i < n + 3; i++) {
            for(int j = m; j < m + 3; j++) {
                if (visited[arr[i][j]]) {
                    return true;
                }
                visited[arr[i][j]] = true;
            }
        }
        return false;
    }
}
 
 
//10
//        7 3 6 4 2 9 5 8 1
//        5 8 9 1 6 7 3 2 4
//        2 1 4 5 8 3 6 9 7
//        8 4 7 9 3 6 1 5 2
//        1 5 3 8 4 2 9 7 6
//        9 6 2 7 5 1 8 4 3
//        4 2 1 3 9 8 7 6 5
//        3 9 5 6 7 4 2 1 8
//        6 7 8 2 1 5 4 3 9