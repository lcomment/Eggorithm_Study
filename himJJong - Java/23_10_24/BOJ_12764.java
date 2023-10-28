import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12764{
    static class time implements Comparable<time>{
        int start;
        int end;
        time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(time o) {
            return Integer.compare(this.start, o.start);
        }
    }
    static class computer implements Comparable<computer>{
        int end;
        int index;
        computer(int end, int index){
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(computer o){
            return Integer.compare(this.end, o.end);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<time> times = new PriorityQueue<time>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times.add(new time(start,end));
        }

        PriorityQueue<computer> comEndTime = new PriorityQueue<computer>();
        PriorityQueue<Integer> nextCom = new PriorityQueue<>();

        int[] comIndex = new int[N+1];
        int comCount = 0;

        for(int i=0; i<N; i++){
            while(!comEndTime.isEmpty() && times.peek().start > comEndTime.peek().end){
                nextCom.add(comEndTime.poll().index);
            }

            if(nextCom.isEmpty()){
                comEndTime.add(new computer(times.poll().end, comCount));
                comIndex[comCount]++;
                comCount++;
            }
            else{
                comEndTime.add(new computer(times.poll().end, nextCom.peek()));
                comIndex[nextCom.poll()]++;
            }
        }

        sb.append(comCount+"\n");
        for(int i=0; i<comCount; i++){
            sb.append(comIndex[i]+" ");
        }
        System.out.println(sb);
    }
}