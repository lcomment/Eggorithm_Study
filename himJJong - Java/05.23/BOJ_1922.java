import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1922 {
    static class Node implements Comparable<Node>{
        int a;
        int b;
        int val;
        Node(int a, int b, int val){
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
    static List<Node> list = new ArrayList<>();
    static int[] computerNode;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computer = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        computerNode = new int[computer+1];

        for(int i=1; i<=computer; i++){
            computerNode[i] = i;
        }

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.add(new Node(a,b,val));
        }

        Collections.sort(list);

        for(int i=0; i<list.size() ; i++){
            if(check()){    //다 연결되었는지
                break;
            }
            if(findParent(list.get(i).a) == findParent(list.get(i).b)){
                continue;
            }
            compareAB(list.get(i).a, list.get(i).b);
            answer += list.get(i).val;
        }

        System.out.println(answer);
    }

    private static void compareAB(int a, int b) {
        int A = findParent(a);
        int B = findParent(b);

        if(findParent(A) > findParent(B))   computerNode[A] = B;
        else computerNode[B] = A;
    }

    private static boolean check() {
        for(int i=0; i<computerNode.length-1; i++){
            if(findParent(computerNode[i]) == findParent(computerNode[i+1]))    continue;
            else return false;
        }
        return true;
    }

    private static int findParent(int a) {
        if(computerNode[a] == a)    return a;
        else return computerNode[a] = findParent(computerNode[a]);
    }
}
