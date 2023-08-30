import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13335 {
    static int time = 0;
    static Queue<Integer> readyQ = new LinkedList<>();
    static Queue<Integer> moveQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        String[] tmp = br.readLine().split(" ");

        for(int i=0; i<tmp.length; i++){
            readyQ.add(Integer.parseInt(tmp[i]));
        }

        for(int i=0; i<w; i++){
            moveQ.add(0);
        }

        int check = 0;
        while(!moveQ.isEmpty()){
            time++;
            check -= moveQ.poll();
            if(!readyQ.isEmpty()){
                if(check + readyQ.peek() <= L){
                    int tmp1 = readyQ.poll();
                    check += tmp1;
                    moveQ.add(tmp1);
                }
                else{
                    moveQ.add(0);
                }
            }
        }
        System.out.println(time);
    }
}
