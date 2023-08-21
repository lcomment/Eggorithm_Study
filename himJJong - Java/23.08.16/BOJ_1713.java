import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1713 {
    static class Node implements Comparable<Node>{
        int num;
        int pickUp;
        int time;
        Node(int num,int pickUp, int time){
            this.num = num;
            this.pickUp = pickUp;
            this.time = time;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setPickUp(int pickUp) {
            this.pickUp = pickUp;
        }

        public void setTime(int time) {
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            if(this.pickUp == o.pickUp){
                return this.time - o.time;
            }
            return this.pickUp - o.pickUp;
        }
    }
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static List<Node> list = new ArrayList<>();
    static int index = 1;
    static int index2 = -1;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int picture = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<count; i++){
            int num = Integer.parseInt(st.nextToken());

            if(i==0){
                list.add(new Node(num,1,index));
                index++;
                continue;
            }

            if(containNum(num)){
                list.get(index2).setPickUp(list.get(index2).pickUp+1);
            }
            else{
                if(list.size() != picture){
                    list.add(new Node(num, 1, index));
                }
                else{
                    changePicture(num);
                    pq.clear();
                }
            }
            index++;
        }

        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            answerList.add(list.get(i).num);
        }

        Collections.sort(answerList);
        for(int i=0; i<answerList.size(); i++){
            System.out.print(answerList.get(i)+" ");
        }
    }

    private static void changePicture(int change) {
        pq.addAll(list);

        Node cur = pq.poll();

        for(int i=0; i<list.size(); i++){
            if(list.get(i).num == cur.num){
                list.get(i).setNum(change);
                list.get(i).setTime(index);
                list.get(i).setPickUp(1);
                return;
            }
        }
    }

    private static boolean containNum(int num) {
        for(int i=0; i<list.size(); i++){
            if(num == list.get(i).num)  {
                index2 = i;
                return true;
            }
        }
        return false;
    }
}
