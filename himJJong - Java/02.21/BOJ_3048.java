import java.io.*;
import java.util.*;

public class BOJ_3048 {
    static int[] NM;
    static String[] left;
    static String[] right;
    static int[] visit;
    static List<String> answer = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        left = br.readLine().split("");
        right = br.readLine().split("");
        visit = new int[left.length + right.length];

        initializeBoolean();
        int time = Integer.parseInt(br.readLine());

        for(int j=left.length-1; j>=0;j--){
            answer.add(left[j]);
        }
        answer.addAll(Arrays.asList(right));

        if(time == 0){
            answerCheck();
        }
        else    {
            simulation(time);
            answerCheck();
        }
    }

    private static void initializeBoolean() {
        for(int i=0; i< left.length; i++){
            visit[i] = 1;
        }
    }

    private static void answerCheck() {
        StringBuilder result = new StringBuilder();

        for (String s : answer) {
            result.append(s);
        }
        System.out.println(result);
    }

    private static void simulation(int time) {
        for(int i=1; i<time+1; i++){
            for(int j=0; j<visit.length-1; j++){
                if(visit[j]==1 && visit[j+1]==0){
                    String val = answer.get(j+1);
                    answer.set(j+1,answer.get(j));
                    answer.set(j,val);

                    visit[j] = 0;
                    visit[j+1] = 1;
                    j++;
                }
            }
        }
    }
}
