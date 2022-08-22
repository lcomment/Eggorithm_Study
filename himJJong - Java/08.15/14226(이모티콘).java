package chapter2;
import java.util.*;
 
public class TypeInference {
	public static class Node {
        int clipboard;
        int total;
        int time;
        
        public Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
    static boolean[][] visited = new boolean[1001][1001];      //[clipboard][total]
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        bfs(s);
    }
    
    public static void bfs(int s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        visited[0][1] = true; 
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(current.total == s) {
                System.out.println(current.time);
                return;
            }
            
            
            q.offer(new Node(current.total, current.total, current.time + 1));   // 화면에 있는 이모티콘 클립보드에 저장
            

                                                                     // 클립보드 값이 있어야하고 , 붙여넣은 후 개수가 총 개수보다 적고 이전에 방문한적 false
            if(current.clipboard != 0 && current.total + current.clipboard <= s && !visited[current.clipboard][current.total + current.clipboard]) {
                q.offer(new Node(current.clipboard, current.total + current.clipboard, current.time + 1));
                visited[current.clipboard][current.total + current.clipboard] = true;
            }
            
                                                                     // 총 개수는 1보다 크거나 같아야하고, 방문한적 false
            if(current.total >= 1 && !visited[current.clipboard][current.total - 1]) {
                q.offer(new Node(current.clipboard, current.total - 1, current.time + 1));
                visited[current.clipboard][current.total - 1] = true;
            }
        }
    }
}
