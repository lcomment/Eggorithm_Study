package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class BOJ_1766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = sToIntArray(br.readLine());
        int N = input[0];
        int M = input[1];
        List<Quiz> quizList = new ArrayList<>();
        int[] count = new int[N+1];
        init(quizList, N);


        for(int i=0 ; i<M ; i++) {
            input = sToIntArray(br.readLine());
            quizList.get(input[0]).priority.add(input[1]);
            count[input[1]]++;
        }

        PriorityQueue<Quiz> pq = new PriorityQueue<>((o1, o2) -> o1.index - o2.index);

        for(int i=1 ; i<=N ; i++) {
            if(count[i] == 0) {
                pq.offer(quizList.get(i));
            }
        }

        while(!pq.isEmpty()) {
            Quiz q = pq.poll();
            System.out.print(q.index + " ");

            for(int idx : q.priority) {
                count[idx]--;

                if(count[idx] == 0) {
                    pq.offer(quizList.get(idx));
                }
            }
        }
    }

    private static void init(List<Quiz> quizList, int N) {
        quizList.add(new Quiz(0));
        for(int i=1 ; i<=N ; i++) {
            quizList.add(new Quiz(i));
        }
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Quiz {
    int index;
    List<Integer> priority = new ArrayList<>();

    Quiz(int index) {
        this.index = index;
    }
}
