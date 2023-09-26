import java.lang.reflect.Array;
import java.util.ArrayList;

public class test1 {
    static boolean[] visited;
    static ArrayList<Integer> same = new ArrayList<>();
    static ArrayList<Integer> differ = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) {
        int n = 2;
        int[][] nationality = {{1,2}};
        list = new ArrayList<>();
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<nationality.length; i++){
            list.get(nationality[i][0]).add(nationality[i][1]);
            list.get(nationality[i][1]).add(nationality[i][0]);
        }
        dfs(1);

        for(int i=1; i<=n; i++){
            if(visited[i])  same.add(i);
            else differ.add(i);
        }

        if(differ.size() == 0){
            System.out.println(-1);
        }
        if(differ.size() == 1){
            System.out.println(same.size() * differ.size());
        }
        int sum =0;
        for(int i=1; i<differ.size(); i++){
            sum += i;
        }
        System.out.println(same.size() * differ.size() + sum);
    }

    private static void dfs(int pos) {
        visited[pos] = true;
        for(int i : list.get(pos)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
