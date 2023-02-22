import java.io.*;
import java.util.*;

public class BOJ_14890 {
    private static int n, L;
    private static int[][] data;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        data = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //다음 블록의 높이가 1차이날때 L길이만큼 확인
        //만약 경사로를 놓을 수 있다면 무슨 처리를.. -> true

        int cnt=0;

        for (int i=1; i<=n; i++) {
            if (check(i,0,0)) {
                //열
                cnt++;
            }
            if (check(0,i,1)) {
                //행
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int x, int y, int flag) {

        int[] height = new int[n + 1];  // 새로 입력 받을 열, 행마다의 데이터 값을 위한 배열
        boolean[] visit = new boolean[n + 1];   // 경사로를 놓았는지 확인하기 위한 boolean 배열

        for (int i = 1; i <= n; i++) {  // 1의 열 과 행 체크, 2의 열과 행 체크 .....
            if (flag == 0) {
                //열 체크
                height[i] = data[x][i];
            } else {
                //행 체크
                height[i] = data[i][y];
            }
        }

        for (int i = 1; i < n; i++) {

            if (height[i] == height[i + 1]) {   // 같을 때 패스
                continue;
            }

            else if (height[i] - 1 == height[i + 1]) {
                //내리막
                //왼 -> 오른쪽
                for (int j = i + 1; j < i + 1 + L; j++) { // 해당 i 인덱스 다음인 j = i+1 ~ L
                    if (j > n) {  //배열 범위를 넘어가지 않는지
                        return false;
                    }
                    if (visit[j]) { // 이미 경사로가 설치 되어 있는지
                        return false;
                    }
                    if (height[i + 1] != height[j]) {   //해당 범위 내 같은 값이어야 하기 때문에 체크
                        return false;
                    }
                    visit[j] = true;
                }
            }

            else if (height[i] + 1 == height[i + 1]) {
                //오르막
                //오른쪽 -> 왼쪽
                for (int j = i; j > i - L; j--) {
                    if (j < 1) {    //배열 범위를 넘어가지 않는지
                        return false;
                    }
                    if (visit[j]) { // 이미 경사로가 설치 되어 있는지
                        return false;
                    }
                    if (height[i] != height[j]) {   //해당 범위 내 같은 값이어야 하기 때문에 체크
                        return false;
                    }
                    visit[j] = true;
                }
            }

            else return false;  // 위 조건 말고는 나머지 다 false

        }
        return true;    // 전부 같은 경우는 true
    }
}