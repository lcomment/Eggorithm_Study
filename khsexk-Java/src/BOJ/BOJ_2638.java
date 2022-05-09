package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BOJ_2638{
 
    public static int n,m,map[][], visit[][];
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new int[n][m];
 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = sc.nextInt();
            }
        }
        int time=0;
        boolean check = true;
        while(check){
        	init();
            bfs();
 
            //치즈 확인
            check = false;
            
            loop:
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]!=0){
                        check = true;
                        break loop;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }
 
    public static void bfs(){
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(0,0));
 
       while(!q.isEmpty()){
           Pair p = q.poll();
 
           for(int i=0;i<4;i++){
               int nx = p.x + dx[i];
               int ny = p.y + dy[i];
 
               if(nx<0 || ny<0 || nx>=n || ny>=m)
               continue;
 
               if(map[nx][ny]==0 && visit[nx][ny]==0){
                   visit[nx][ny] =1;
                   q.add(new Pair(nx,ny));
               }
               if(map[nx][ny]==1){
                   visit[nx][ny]++;
                   if(visit[nx][ny]>=2)
                   map[nx][ny] =0;
               }
           }
       }
    }
 
    public static void init(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visit[i][j] = 0;
            }
        }
    }
}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}