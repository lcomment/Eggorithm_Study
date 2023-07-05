import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17503 {
    static class Beer{
        int prefer;
        int alcohol;
        Beer(int prefer, int alcohol){
            this.prefer = prefer;
            this.alcohol = alcohol;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int date = Integer.parseInt(st.nextToken());
        int happy = Integer.parseInt(st.nextToken());
        int beer = Integer.parseInt(st.nextToken());

        Queue<Integer> prefers = new PriorityQueue<>();
        List<Beer> beers = new ArrayList<>();

        for(int i=0; i<beer; i++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            beers.add(new Beer(p,a));
        }

        beers.sort(new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                if (o1.alcohol == o2.alcohol) {
                    return o2.prefer - o1.prefer;
                }
                return o1.alcohol - o2.alcohol;
            }
        });

        int total = 0;
        int answer = -1;

        for(Beer beer1 : beers){
            prefers.add(beer1.prefer);
            total += beer1.prefer;

            if(prefers.size() > date){
                total -= prefers.poll();
            }
            if(prefers.size() == date && total >= happy){
                answer = beer1.alcohol;
                break;
            }
        }
        System.out.println(answer);
    }
}