import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2457 {
    static class Node{
        int a,b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            list.add(new Node(a, b));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.a==o2.a) return o1.b-o2.b;
                return o1.a-o2.a;
            }
        });
        int max = 0,ans = 0;
        int start = 301;
        int idx = 0;

        while(start<1201) {
            boolean ch = false;
            for(int i=idx; i<N; i++) {
                if(list.get(i).a > start) break;
                //a값이 max값보다 작은 것들 중 b의 값이 가장 큰것을 선택
                if(max<list.get(i).b) {
                    max = list.get(i).b;
                    idx = i+1;
                    ch = true;
                }
            }
            if(ch) {
                start = max;
                ans++;
            }
            else break;
        }
        if(max<1201) System.out.println(0);
        else System.out.println(ans);
    }
}