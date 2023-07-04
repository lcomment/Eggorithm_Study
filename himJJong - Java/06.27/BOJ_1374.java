import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1374 {
    static class Data{
        int start;
        int end;
        Data(int start, int end){
            this.start = start;
            this.end = end;
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        Queue<Integer> pq = new PriorityQueue<>();
        List<Data> list = new ArrayList<>();

        int classroom = Integer.parseInt(br.readLine());

        for(int i=0; i<classroom; i++){
            st = new StringTokenizer(br.readLine());

            int classNumber = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Data(s,e));
        }

        list.sort(new Comparator<Data>(){
            @Override
            public int compare(Data o1, Data o2){
                if(o1.start == o2.start){
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        for(int i=0; i<classroom; i++){
            if(pq.size() == 0){
                pq.add(list.get(i).end);
                continue;
            }
            if(pq.peek() > list.get(i).start){
                pq.add(list.get(i).end);
            }
            else{
                pq.poll();
                pq.add(list.get(i).end);
            }
        }
        System.out.println(pq.size());
    }
}
