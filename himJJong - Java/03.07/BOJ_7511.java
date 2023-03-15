import java.io.*;
import java.util.*;

public class BOJ_7511 {
    static int[]friendship;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++){
            int friend = Integer.parseInt(br.readLine());
            friendship = new int[friend];

            initialize(friend);
            StringBuilder sb = new StringBuilder();
            int friendshipData = Integer.parseInt(br.readLine());

            for(int j=0; j<friendshipData; j++){
                st = new StringTokenizer(br.readLine());
                int friendA = Integer.parseInt(st.nextToken());
                int friendB = Integer.parseInt(st.nextToken());

                compareAB(friendA, friendB);
            }
            if(i>0) System.out.println();
            sb.append("Scenario ").append(i + 1).append(":").append("\n");
            int check = Integer.parseInt(br.readLine());

            for(int j=0; j<check ;j++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                if(findParent(A) == findParent(B)) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            System.out.print(sb);
        }
    }
    private static int findParent(int val){
        if(friendship[val] == val) return val;
        else return friendship[val] = findParent(friendship[val]);
    }

    private static void compareAB(int friendA, int friendB) {
        int A = findParent(friendA);
        int B = findParent(friendB);

        if(findParent(A) > findParent(B)) friendship[A] = B;
        else friendship[B] = A;
    }

    private static void initialize(int friend) {
        for(int i=0; i<friend; i++){
            friendship[i] = i;
        }
    }
}