import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15787 {
    static int[] train;
    static int[] NM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        train = new int[NM[0]+1];

        for(int i=0; i<NM[1];i++){
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());


            if(order ==1){
                int place = Integer.parseInt(st.nextToken());
                actOne(trainNum,place);
            }
            else if(order==2){
                int place = Integer.parseInt(st.nextToken());
                actTwo(trainNum,place);
            }
            else if(order==3){
                actThird(trainNum);
            }
            else if(order==4){
                actFourth(trainNum);
            }
        }

        boolean visited[] = new boolean[1 << 21];
        for (int i = 1; i <= NM[0]; i++) {

            if(visited[train[i]]) continue;
            else {
                answer++;
                visited[train[i]]=true;
            }
        }
        System.out.println(answer);
    }

    private static void actFourth(int trainNum) {
        train[trainNum] = train[trainNum] >> 1;
        train[trainNum] = train[trainNum] & ~1;
    }

    private static void actThird(int trainNum) {
        train[trainNum] = train[trainNum] << 1;
        train[trainNum] = train[trainNum] & ((1<<21)-1);
    }

    private static void actTwo(int trainNum, int place) {
        train[trainNum] = train[trainNum] & ~(1<<place);
    }

    private static void actOne(int trainNum, int place) {
        train[trainNum] = train[trainNum] | (1<<place);
    }
}