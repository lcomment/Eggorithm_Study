import java.util.*;

class pro_connectIsland {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1,o2) -> Integer.compare(o1[2], o2[2]));
        parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int i=0; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0],costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    private static int find(int val){
        if(parent[val] == val)  return val;
        return find(parent[val]);
    }
    private static void union(int a, int b){
        int c = find(a);
        int d = find(b);

        if(c < d){
            parent[d] = c;
        }
        else{
            parent[c] = d;
        }
    }
}