import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2668 {
    static int[] arr;
    static boolean[] visited;
    static int last;
    static ArrayList<Integer> list;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = true;              // 무한 재귀에 빠지면 안되므로 첫 시작점도 방문으로 체크
            last = i;
            DFS(i);
            visited[i] = false;             // 다음 숫자 DFS를 해야하므로 초기화 시켜준다.
        }
        Collections.sort(list);             // 작은수 부터 출력해야하므로 정렬
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);          // list들을 하나씩 출력해준다.
        }
    }

    public static void DFS(int i) {
        if (!visited[arr[i]]) {             // 이전에 방문한 점이 아니여야한다.
            visited[arr[i]] = true;         // 방문했으므로 true
            DFS(arr[i]);
            visited[arr[i]] = false;        // 다음 DFS들을 위하여 false
        }
        if (arr[i] == last) {               //  마지막 점이 출발점과 같다면 사이클이 완성됐으므로 리스트에 추가
            list.add(last);
        }
    }
}
