import java.io.*;
import java.util.*;
public class BOJ_1744 {
    static class Node implements Comparable<Node> {
        int num;

        Node(int num) {
            this.num = num;
        }

        public int compareTo(Node o) {
            return o.num - this.num;
        }
    }
    static int n;
    static Node arr[];
    static long ans = 0;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new Node[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = new Node(num);
        }
        Arrays.sort(arr);

        int one = 0;

        for(int i=0; i<n; i++) {
            if(arr[i].num>1) {      // 양수 일 때
                if(i+1<n && arr[i+1].num>1) {   //인덱스 범위 안 벗어 날 때
                    ans += arr[i].num * arr[i+1].num;
                    visited[i] =true;
                    visited[i+1]=true;
                    i++;
                }
            }
            else if(arr[i].num==1) {     //1 일때는 곱하는 것 보다 무조건 더하는게 좋음
                one++;
                visited[i]=true;
            }
            else {  // 음수 일 때  -1 -5 -6 이렇게 정렬 돼 있을꺼
                for(int j= n-1; j>=i; j--) {
                    if(j-1 >=i) {
                        ans+= arr[j].num * arr[j-1].num;
                        visited[j]=true;
                        visited[j-1]=true;
                        j--;
                    }
                    else {
                        visited[j]= true;
                        ans+=arr[j].num;
                    }
                }
                break;
            }
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                ans+=arr[i].num;
            }
        }
        System.out.println(ans+one);
    }
}