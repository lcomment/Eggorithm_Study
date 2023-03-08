import java.util.*;
import java.io.*;

public class BOJ_1202 {
    static public class Jewel{
        private int weight;
        private int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    static int jewelCount;
    static int backpackCount;
    static List<Jewel> jewelList = new ArrayList<>();
    static List<Integer> backpackList = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        dataCollect();
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((e1, e2) -> { //값어치 높은거부터
            return e2 - e1;
        });
        Comparator<Jewel> comparator = new Comparator<Jewel>() {
            @Override
            public int compare(Jewel a, Jewel b) {
                return a.weight - b.weight;
            }
        };

        jewelList.sort(comparator);
        Collections.sort(backpackList);

        int idx = 0;

        for(int i=0; i<backpackCount; i++){
            int tmpBag = backpackList.get(i);
            while(idx < jewelCount) {
                if(jewelList.get(idx).weight <= tmpBag) {
                    pq.add(jewelList.get(idx).value);
                    idx++;
                }
                else break;
            }
            if(!pq.isEmpty()){
                answer += pq.poll();            //제일 큰 가치가 앞에 있으므로 가능
            }
        }
        System.out.println(answer);
    }

    private static void dataCollect() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        jewelCount = Integer.parseInt(st.nextToken());
        backpackCount = Integer.parseInt(st.nextToken());

        for(int i=0; i<jewelCount; i++){
            st = new StringTokenizer(br.readLine());
            int jewelWeight = Integer.parseInt(st.nextToken());
            int jewelPrice = Integer.parseInt(st.nextToken());
            Jewel jewel = new Jewel(jewelWeight, jewelPrice);
            jewelList.add(jewel);
        }
        for(int i=0; i<backpackCount; i++){
            backpackList.add(Integer.parseInt(br.readLine()));
        }
    }
}
