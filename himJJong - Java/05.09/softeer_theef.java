import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class softeer_theef {
    static class Node implements Comparable<Node>{
        int weight;
        int gram;
        Node(int weight, int gram){
            this.weight = weight;
            this.gram = gram;
        }

        @Override
        public int compareTo(Node o) {
            return o.gram - this.gram;
        }
    }
    static List<Node> list = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int backpack = Integer.parseInt(st.nextToken());
        int jewelCount = Integer.parseInt(st.nextToken());
        int answer = 0;

        for(int i=0; i<jewelCount; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Node(a,b));
        }

        Collections.sort(list);

        while(backpack != 0){
            if(list.get(0).weight < backpack){
                backpack -= list.get(0).weight;
                answer += list.get(0).gram * list.get(0).weight;

                list.remove(0);
            }
            else if(list.get(0).weight > backpack){
                answer += backpack * list.get(0).gram;
                backpack = 0;
                list.remove(0);
            }
            else{
                backpack -= list.get(0).weight;
                answer += list.get(0).gram * list.get(0).weight;
            }
        }
        System.out.println(answer);
    }
}
