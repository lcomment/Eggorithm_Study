import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int cnt = Integer.MAX_VALUE;

        int subCnt = 0;
        boolean sw = false;
        for(int i=0;i<N;i++) {
            if(sw && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'B') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        subCnt = 0;
        sw = false;
        for(int i=0;i<N;i++) {
            if(sw && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'R') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        subCnt = 0;
        sw = false;
        for(int i=N-1;i>=0;i--) {
            if(sw && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'B') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        subCnt = 0;
        sw = false;
        for(int i=N-1;i>=0;i--) {
            if(sw && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'R') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        System.out.println(cnt);
    }
}
