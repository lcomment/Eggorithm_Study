import java.util.*;

public class BOJ_2251 {
    static class Water{
        int x;
        int y;
        int z;
        Water(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int A;
    static int B;
    static int C;
    static boolean[][][] visited = new boolean[201][201][201];
    static List<Integer> answerList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        bfs();
        Collections.sort(answerList);
        for(int i=0; i<answerList.size(); i++){
            System.out.print(answerList.get(i)+" ");
        }
    }

    private static void bfs() {
        Queue<Water> q = new LinkedList<>();
        q.add(new Water(0,0,C));

        while(!q.isEmpty()){
            Water water = q.poll();
            int a = water.x;
            int b = water.y;
            int c = water.z;

            if(visited[a][b][c])    continue;

            visited[a][b][c] = true;
            if(a == 0)  answerList.add(c);

            //A -> B
            if(a + b >= B){ q.add(new Water(a-(B-b), B, c));} //옮기면 넘치는 경우
            else { q.add(new Water(0, a+b, c)); }
            //A -> C
            if(a + c >= C) { q.add(new Water(a-(C-c), b, C));}
            else { q.add(new Water(0, b, a+c)); }
            //B -> A
            if(b + a >= A){ q.add(new Water(A, b-(A-a), c)); }
            else { q.add(new Water(b+a, 0, c)); }
            //B -> C
            if(b + c >= C){ q.add(new Water(a, b-(C-c), C)); }
            else { q.add(new Water(a, 0, b+c)); }
            //C -> A
            if(c + a >= A) { q.add(new Water(A, b, c-(A-a)));}
            else{ q.add(new Water(a+c, b, 0)); }
            //C -> B
            if(c + b >= B) { q.add(new Water(a, B, c-(B-b)));}
            else{ q.add(new Water(a, b+c, 0)); }
        }
    }
}
