import java.io.*;
import java.util.*;


public class BOJ_19637 {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] gradeName = new String[N];
        int[] gradeNum = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            gradeName[i] = st.nextToken();
            gradeNum[i] = Integer.parseInt(st.nextToken());
        }

        int [] data = new int[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int left = 0;
            int right = N-1;

            while(left <= right){
                int center = (left+right)/2;
                if(gradeNum[center] < data[i]) left = center + 1;
                else right = center - 1;
            }
            bw.write(gradeName[left]+"\n");
        }
        bw.flush();
    }
}