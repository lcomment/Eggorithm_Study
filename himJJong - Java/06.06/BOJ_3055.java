import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3055 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int row;
    static int col;
    static int moveCount = 0;
    static String[][] data;
    static boolean[][] visited;
    static List<Node> waterList = new ArrayList<>();
    static List<Node> dList = new ArrayList<>();
    static int goalX;
    static int goalY;
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        data = new String[row][col];
        visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            String tmp = br.readLine();
            for(int j=0; j<col; j++){
                data[i][j] = String.valueOf(tmp.charAt(j));
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(data[i][j].equals("*"))  {
                    waterList.add(new Node(i,j));
                }
                if(data[i][j].equals("S")){
                    dList.add(new Node(i,j));
                }
                if(data[i][j].equals("D")){
                    goalX = i;
                    goalY = j;
                }
            }
        }
        
        while(true){
            int waterSize = waterList.size();
            while (waterSize-- >0){
                waterCheck(waterList.remove(0));
            }

            int size = dList.size();
            if(size == 0){
                System.out.println("KAKTUS");
                System.exit(0);
            }
            while (size -- >0){
                dCheck(dList.remove(0));
            }
            moveCount++;
        }
    }

    private static void dCheck(Node node) {
        Node tmp = node;
        data[tmp.x][tmp.y] = ".";
        visited[tmp.x][tmp.y] = true;
        for(int i=0; i<4; i++){
            int move_x = tmp.x + dx[i];
            int move_y = tmp.y + dy[i];
            if(move_x == goalX && move_y == goalY){
                System.out.println(moveCount+1);
                System.exit(0);
            }
            if(move_x >=0 && move_y >=0 && move_x <row && move_y <col && data[move_x][move_y].equals(".") && !visited[move_x][move_y]){
                data[move_x][move_y] = "S";
                dList.add(new Node(move_x,move_y));
            }
        }
    }

    private static void waterCheck(Node node) {
        Node tmp = node;

        for(int i=0; i<4; i++) {
            int move_x = tmp.x + dx[i];
            int move_y = tmp.y + dy[i];

            if(move_x >=0 && move_y >=0 && move_x <row && move_y <col && data[move_x][move_y].equals(".")){
                data[move_x][move_y] = "*";
                waterList.add(new Node(move_x,move_y));
            }
        }
    }

}
