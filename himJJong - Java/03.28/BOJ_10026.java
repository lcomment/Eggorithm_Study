import java.io.*;
import java.util.*;

public class BOJ_10026 {
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String[][] data;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<String> compare = new ArrayList<>();
    static List<Node> list = new ArrayList<>();
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        data = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    Node tmp = new Node(i, j);
                    visited[i][j] = true;
                    list.add(tmp);
                    compare.add(data[i][j]);
                    checkNo();
                    count++;
                }
                compare.clear();
            }
        }
        System.out.print(count + " ");

        visited = new boolean[N][N];
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    Node tmp = new Node(i, j);
                    visited[i][j] = true;
                    list.add(tmp);
                    compare.add(data[i][j]);
                    checkYes();
                    count++;
                }
                compare.clear();
            }
        }
        System.out.println(count);
    }

    private static void checkYes() {
        while (!list.isEmpty()) {
            Node current = list.remove(0);
            for (int i = 0; i < 4; i++) {
                int move_x = current.x + dx[i];
                int move_y = current.y + dy[i];

                if(move_x < 0 || move_y < 0 || move_x >= N || move_y >= N || visited[move_x][move_y]) continue;
                if (compare.get(0).equals("R") || compare.get(0).equals("G")) {
                    if ((data[move_x][move_y].equals("R") || data[move_x][move_y].equals("G"))) {
                        visited[move_x][move_y] = true;
                        Node add = new Node(move_x, move_y);
                        list.add(add);
                    }
                }
                else {
                    if (data[move_x][move_y].equals("B")) {
                        visited[move_x][move_y] = true;
                        Node add = new Node(move_x, move_y);
                        list.add(add);
                    }
                }
            }
        }
    }


    private static void checkNo() {
        while (!list.isEmpty()) {
            Node current = list.remove(0);
            for (int i = 0; i < 4; i++) {
                int move_x = current.x + dx[i];
                int move_y = current.y + dy[i];

                if (move_x >= 0 && move_y >= 0 && move_x < N && move_y < N && !visited[move_x][move_y] && data[move_x][move_y].equals(compare.get(0))) {
                    visited[move_x][move_y] = true;
                    Node add = new Node(move_x, move_y);
                    list.add(add);
                }

            }
        }
    }
}