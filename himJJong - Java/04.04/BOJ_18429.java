import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_18429 {
    static int healthMachine;
    static int minus;
    static int[] machineNumber;
    static int count;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        healthMachine = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());

        machineNumber = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        visited = new boolean[healthMachine];

        backTracking(500,0);
        System.out.println(count);
    }

    private static void backTracking(int weight, int depth) {
        if(depth == healthMachine) {
            count++;
            return;
        }

        for(int i=0; i<healthMachine; i++){
            if(!visited[i] && (weight + machineNumber[i] - minus) >= 500){
                visited[i] = true;
                backTracking(weight + machineNumber[i] - minus,depth+1);
                visited[i] = false;
            }
        }
    }
}
