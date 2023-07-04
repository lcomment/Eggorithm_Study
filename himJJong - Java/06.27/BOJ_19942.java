import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19942 {
    static int total = Integer.MAX_VALUE;
    static int count;
    static int[] min_nutrution;
    static int[] answer;
    static int[][] data;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(br.readLine());
        min_nutrution = new int[4];
        data = new int[count+1][5];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++){
            min_nutrution[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=count; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<= count; i++){
            answer = new int[count];
            backTracking(0,i,1);
        }

        if(total == Integer.MAX_VALUE) System.out.println(-1);
        else{
            Collections.sort(list);
            System.out.println(total);
            System.out.println(list.get(0));
        }
    }

    private static void backTracking(int cnt, int choiceNum, int at) {
        if(cnt == choiceNum){
            isCheck(choiceNum);
            return;
        }
        for(int i=at; i<=count; i++){
            answer[cnt] = i;
            backTracking(cnt+1, choiceNum, i+1);
        }
    }

    private static void isCheck(int choiceNum) {
        int[] check = new int[4];
        int price = 0;
        for(int i=0; i<choiceNum; i++){
            for(int j=0; j<4; j++){
                check[j] += data[answer[i]][j];
            }
            price += data[answer[i]][4];
        }

        for(int i=0; i<4; i++)
            if (check[i] < min_nutrution[i]) return;

            if(total >= price){
                if(total > price)   list.clear();
                StringBuilder sb = new StringBuilder();

                for(int j=0; j<choiceNum; j++){
                    sb.append(answer[j]+" ");
                }
                list.add(sb.toString());
                total = price;
            }
    }
}
