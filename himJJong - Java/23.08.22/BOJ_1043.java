import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_1043 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int people = Integer.parseInt(inputs[0]);
        int party = Integer.parseInt(inputs[1]);
        boolean[] people_know = new boolean[people+1];

        HashSet<Integer>[] parties = new HashSet[party+1];
        for (int i = 1; i <= party; i++) {
            parties[i] = new HashSet<>();
        }

        inputs = br.readLine().split(" ");
        int know_num = Integer.parseInt(inputs[0]);

        for (int i = 1; i <= know_num; i++) { // 진실을 아는사람 T
            int tmp = Integer.parseInt(inputs[i]);
            people_know[tmp] = true;
        }

        parent = new int[people + 1];
        for (int i = 1; i <= people; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= party; i++) {
            inputs = br.readLine().split(" ");
            int party_num = Integer.parseInt(inputs[0]);
            if(i==4){
                int k = 21;
            }

            if(party_num<=1) {
                parties[i].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for (int j = 1; j < party_num; j++) {
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);
                if (find(a) != find(b)) {
                    union(a,b);
                }

                parties[i].add(a);
                parties[i].add(b);
            }
        }

        boolean[] visited = new boolean[people + 1];
        for (int i = 1; i <= people; i++) {
            if(people_know[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= people; j++){
                    if (find(j)==root) {
                        people_know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= party; i++) {
            boolean flag = false;
            for (int person : parties[i]) {
                if(people_know[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);
    }

    public static int find(int idx) {
        if(parent[idx]==idx){
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a; // b의 parent를 a로 변경
    }

}