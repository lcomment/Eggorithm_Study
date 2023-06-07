import java.util.*;
class programmers_island {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int row;
    static int col;
    static boolean[][] visited;
    static String[][] data;
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();

        row = maps.length;
        col = maps[0].length();
        visited = new boolean[row][col];
        data = new String[row][col];

        for(int i=0; i<row; i++){
            String tmp = maps[i];
            data[i] = tmp.split("");
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!data[i][j].equals("X") && !visited[i][j]){
                    Node tmp = new Node(i,j);
                    int count = bfs(tmp) + Integer.parseInt(data[i][j]);
                    list.add(count);
                }
            }
        }

        if(list.size() == 0){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    private static int bfs(Node tmp) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        visited[tmp.x][tmp.y] = true;
        q.add(tmp);

        while (!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0; i<4; i++){
                int moveX = cur.x + dx[i];
                int moveY = cur.y + dy[i];

                if(moveX >=0 && moveY >=0 && moveX <row && moveY <col && !data[moveX][moveY].equals("X") && !visited[moveX][moveY]){
                    visited[moveX][moveY] = true;
                    answer += Integer.parseInt(data[moveX][moveY]);
                    q.add(new Node(moveX, moveY));
                }
            }

        }
        return answer;
    }
}