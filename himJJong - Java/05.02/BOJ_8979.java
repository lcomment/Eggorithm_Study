import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_8979 {
    static class Nation implements Comparable<Nation> {
        int num, gold, silver, bronze;

        public Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else return o.silver - this.silver;
            } else
                return o.gold - this.gold;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<Nation> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(tmp.nextToken());
            int gold = Integer.parseInt(tmp.nextToken());
            int silver = Integer.parseInt(tmp.nextToken());
            int bronze = Integer.parseInt(tmp.nextToken());

            Nation nation = new Nation(num, gold, silver, bronze);
            list.add(nation);
        }

        Collections.sort(list);

        int rank = 1;
        int count = 0;

        if(list.get(0).num == t) {
            System.out.println(1);
            System.exit(0);
        }

        for(int i=0; i<n-1;i++){
            if(list.get(i).num == t) {
                System.out.println(rank);
                System.exit(0);
            }
            if(list.get(i).gold == list.get(i+1).gold && list.get(i).silver == list.get(i+1).silver && list.get(i).bronze == list.get(i+1).bronze){
                count++;
                continue;
            }
            rank += count;
            count=0;
            rank++;
        }
        System.out.println(rank);
    }
}