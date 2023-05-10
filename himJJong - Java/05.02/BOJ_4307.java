import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4307 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int tree = Integer.parseInt(st.nextToken());
            int ant = Integer.parseInt(st.nextToken());
            int mid = tree/2;

            int[] antData = new int[ant];

            int min = 1000000;
            int max = 0;

            for(int j=0; j<ant; j++){
                antData[j] = Integer.parseInt(br.readLine());
                if(antData[j] >= mid)   min = Math.min(min,antData[j]);
                else max = Math.max(max,antData[j]);
            }

            Arrays.sort(antData);
            System.out.println(Math.max(tree-min,max)+" "+Math.max(tree-antData[0], antData[ant-1]));
        }

    }
}

