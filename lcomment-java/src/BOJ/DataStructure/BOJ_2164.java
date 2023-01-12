package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = sToI(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i=1 ; i<=N ; i++) {
            q.offer(i);
        }

        if(q.size() == 1) {
            System.out.println(q.poll());
            return;
        }

        while(q.size() != 1) {
            q.poll();

            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
