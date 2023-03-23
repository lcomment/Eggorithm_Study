import java.io.*;
import java.util.*;

public class BOJ_2583 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
    static boolean[][] vistied;
    static List<Node> q = new ArrayList<Node>();
    static List<Integer> answerData = new ArrayList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] NM;
    static int count = 0;
    static int area = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        List<Integer> answer = new ArrayList<>();
        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        vistied = new boolean[NM[0]][NM[1]];

        for(int k =0; k<NM[2]; k++){
            // fillSquare[0] fillSquare[1] fillSquare[2] fillSquare[3]
            int[] fillSquare = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int j=fillSquare[0]; j<fillSquare[2]; j++){
                for(int i=fillSquare[1]; i<fillSquare[3]; i++){
                    vistied[i][j] = true;
                }
            }
        }


        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(!vistied[i][j]){
                    bfs(new Node(i,j));
                    answer.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(answer);

        System.out.println(answer.size());

        for (int i=0; i<answer.size();i++){
            if (answer.get(i)==0) System.out.print(answer.get(i)+1+" ");
            else System.out.print(answer.get(i)+" ");
        }
    }

    private static void bfs(Node node) {
        q.add(node);
        while(!q.isEmpty()){
            Node tmp = q.remove(0);
            for(int i=0; i<4; i++){
                int moveX = tmp.x + dx[i];
                int moveY = tmp.y + dy[i];
                if(moveX>=0 && moveX<NM[0] && moveY>=0 && moveY<NM[1] && !vistied[moveX][moveY]){
                    count++;
                    vistied[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
            }
        }

    }
}
