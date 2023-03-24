import java.io.*;
import java.util.*;

public class BOJ_3020 {
    static int [] up;
    static int [] down;
    static int n,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n  = Integer.parseInt(s[0]);
        h  = Integer.parseInt(s[1]);

        up = new int[n/2];
        down = new int[n/2];

        for(int i=0; i<n/2; i++) {
            int num1 = Integer.parseInt(br.readLine());
            int num2 = Integer.parseInt(br.readLine());
            down[i]=num1;
            up[i]=num2;
        }

        int min = n;
        int count=0;

        Arrays.sort(up);
        Arrays.sort(down);


        for(int i=1; i<=h; i++){
            int countWall = solve(0,n/2,i,down)+solve(0,n/2,h-i+1, up);

            if(min==countWall){
                count++;
                continue;
            }
            if(min>countWall){
                min=countWall;
                count=1;
            }
        }
        System.out.println(min+" "+count);
    }

    private static int solve(int left, int right, int h, int[]arr){
        while(left<right) {
            int mid = (left+right)/2;

            if(arr[mid] >= h) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return arr.length-right;
    }
}

// 정리
// 문제를 풀이할 떄 알아낸 것은 , 최솟값은 N/2 or 정중앙쪽 중에 존재한다. 이 최솟값을 한번의 반복문을 돌리며 부술 수 있는 개수와 같다면 count를 증가 시키려했다. -> 시간초과
// 풀이를 보니 이진탐색이었고, 평소에 봤던 일반적인 이진탐색 문제와 다르게 느껴져 신박했던 것 같다.