import java.io.*;
import java.util.*;

public class BOJ_3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int t = Integer.parseInt(input);

        while(t-- > 0) {
            input = br.readLine();
            int n, k, id, m;
            int[]  problem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = problem[0];
            k = problem[1];
            id = problem[2];
            m = problem[3];

            int score[][] = new int[n+1][k+1];  // 팀별 문제별 점수
            int cnt[] = new int[n+1];           // 팀별 제출 횟수
            int time[] = new int[n+1];          // 팀별 마지막 제출 시간

            // m개의 로그 읽어서 저장
            int index = 0;
            while(m --> 0) {
                input = br.readLine();
                int[] testcase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a = testcase[0];
                int b = testcase[1];
                int c = testcase[2];

                score[a][b] = Math.max(score[a][b], c);
                cnt[a]++;
                time[a] = index;
                index++;
            }

            Ranking res[] = new Ranking[n];
            for(int i = 1; i<=n; i++){
                int sum = 0;
                for(int j = 1; j<=k; j++){
                    sum += score[i][j];
                }
                res[i-1] = new Ranking(sum, cnt[i], time[i], i);
            }
            Arrays.sort(res);
            for(int i = 0; i<n; i++){
                if(res[i].id == id){
                    bw.write(Integer.toString(i+1)+'\n');
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static class Ranking implements Comparable<Ranking> {
        int score;
        int cnt;
        int time;
        int id;

        Ranking(int score, int cnt, int time, int id) {
            this.score = score;
            this.cnt = cnt;
            this.time = time;
            this.id = id;
        }

        @Override
        public int compareTo(Ranking s){
            if(this.score < s.score) return 1;
            else if(this.score == s.score){
                if(this.cnt > s.cnt) return 1;
                else if(this.cnt == s.cnt){
                    if(this.time > s.time) return 1;
                    else return -1;
                }
                else return -1;
            }
            else return -1;
        }
    }
}