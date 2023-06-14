import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5568 {
    static int card;
    static int pick;
    static int[] data;
    static int[] answer;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        card = Integer.parseInt(br.readLine());
        pick = Integer.parseInt(br.readLine());

        data = new int[card];

        for(int i=0; i<card; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        answer = new int[pick];
        visited = new boolean[card];

        backTracking(0);
        System.out.println(list.size());
    }

    private static void backTracking(int val) {
        if(val == pick){
            String tmp = "";
            for(int i=0; i<pick; i++){
                tmp += answer[i];
            }
            if(!list.contains(Integer.parseInt(tmp))){
                list.add(Integer.parseInt(tmp));
            }
            return;
        }

        for(int i=0; i<card; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[val] = data[i];
                backTracking(val+1);
                visited[i] = false;
            }
        }
    }
}
