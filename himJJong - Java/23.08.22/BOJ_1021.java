import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        int[] find = new int[M];

        for(int i=1; i<=N; i++){
            dq.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            find[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        for(int i=0; i<M; i++){ //i는 find 할 요소
            int leftSpin = 0;
            int rightSpin = 0;

            if(find[i] == dq.peekFirst()){
                dq.pollFirst();
                continue;
            }

            while(true){
                int tmp = dq.pollFirst();
                dq.addLast(tmp);
                leftSpin++;
                if(dq.peekFirst() == find[i])   break;
            }
            for(int j=0; j<leftSpin; j++){
                dq.addFirst(dq.pollLast());
            }

            while(true){
                int tmp = dq.pollLast();
                dq.addFirst(tmp);
                rightSpin++;
                if(dq.peekFirst() == find[i])   break;
            }
            for(int j=0; j<rightSpin; j++){
                dq.addLast(dq.pollFirst());
            }

            int leftAnswer = leftSpin;
            int rightAnswer = rightSpin;

            if(leftSpin > rightSpin){
                while(rightSpin-- >0){
                    dq.addFirst(dq.pollLast());
                }
                dq.pollFirst();
                answer += rightAnswer;
            }
            else{
                while(leftSpin-- >0){
                    dq.addLast(dq.pollFirst());
                }
                dq.pollFirst();
                answer += leftAnswer;
            }
        }
        System.out.println(answer);
    }
}
