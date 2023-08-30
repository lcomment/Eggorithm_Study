import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 골드 4 - 나무 재테크
 */
public class BOJ_17070 {
    static int n, m, k;
    static int[][] map;
    static int[][] yangboon;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static LinkedList<Tree> trees;
    static Queue<Tree> dead;
    static int year;

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1]; // 1부터 시작
        yangboon = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = 5;
                yangboon[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        trees = new LinkedList<>();
        dead = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            trees.add(
                    new Tree(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        year = 0;
        simulate();
        System.out.println(trees.size());
    }
    static void simulate() {
        while (true) {
            if (year == k) return;

            // 봄
            Iterator<Tree> iterator = trees.iterator();
            while (iterator.hasNext()) {
                Tree tree = iterator.next();
                int r = tree.x;
                int c = tree.y;
                int age = tree.age;
                if (map[r][c] - age < 0) {
                    // 먹지못하고 즉시 죽음
                    dead.offer(tree);
                    iterator.remove(); /* LinkedList에서 iterator를 통한 remove : O(1) */
                } else {
                    map[r][c] -= age;
                    tree.age += 1;
                }
            }

            // 여름
            while (!dead.isEmpty()) {
                Tree tree = dead.poll();
                map[tree.x][tree.y] += tree.age / 2;
            }

            // 가을
            LinkedList<Tree> babyTrees = new LinkedList<>();
            for (Tree tree : trees) {
                int r = tree.x;
                int c = tree.y;
                if (tree.age % 5 != 0) continue;
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 1 || nc < 1 || nr > n || nc > n) continue;
                    babyTrees.add(new Tree(nr, nc, 1));
                }
            }
            /* LinkedList에서 addAll : O(1) */
            trees.addAll(0, babyTrees);

            // 겨울
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] += yangboon[i][j];
                }
            }
            year++;
        }
    }
}
