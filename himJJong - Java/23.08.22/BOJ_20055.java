import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20055 {
    static List<Integer> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static int time = 0;
    static boolean[] robot;
    static int zeroCount = 0;
    static int N;
    static int K;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        robot = new boolean[N];

        String[] tmp = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(tmp[i]));
        }
        // 1 2 1       2 1 2
        // 2 1 2       1 2 1

        for (int i = 2*N - 1; i >= N; i--) {
            q.add(Integer.parseInt(tmp[i]));
        }

        while(zeroCount<K) {
            time++;
            spinBelt();
            checkRobot();
            putRobot();
        }
        System.out.println(time);
    }

    private static void putRobot() {
        if(list.get(0) ==1){
            robot[0] = true;
            list.set(0,list.get(0)-1);
            zeroCount++;
        }
        else if(list.get(0) > 1){
            robot[0] = true;
            list.set(0,list.get(0)-1);
        }
    }

    private static void checkRobot() {
        if(robot[N-1])  robot[N-1] = false;
        for(int i=N-2; i>=0; i--){
            if(robot[i] && list.get(i+1) >= 1 && !robot[i+1]) {
                robot[i] = false;
                robot[i + 1] = true;
                if (i + 1 == N - 1 && robot[i + 1]) {
                    robot[i + 1] = false;
                }
                list.set(i + 1, list.get(i + 1) - 1);
                if (list.get(i + 1) == 0) zeroCount++;
            }
        }
    }

    private static void spinBelt() {
        q.add(list.get(list.size()-1));

        for(int i=list.size()-1; i>=1; i--){
            list.set(i,list.get(i-1));
        }
        list.set(0,q.poll());

        if(robot[N-1])  robot[N-1] = false;
        if(robot[N-2])  robot[N-2] = false;
        for(int i=N-3; i>=0; i--){
            if(robot[i]){
                robot[i] = false;
                robot[i+1] = true;
            }
        }
    }
}
