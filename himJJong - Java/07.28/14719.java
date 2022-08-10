package algorithm;
import java.util.*;
import java.io.*;

public class plus {
    static int H;
    static int W;
    static int[] wall;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);			//스캐너를 쓴 이유라면 버퍼를 쓸만큼 주어진 범위값이 크지 않아
        H = sc.nextInt(); // 세로 						//시간 복잡도는 O(n^2)..?
        W = sc.nextInt(); // 가로

        int answer = 0;
        int min = 0;
        int value = 0;
        wall = new int[W];

        for(int i=0; i<W; i++) {						//각 가로 1칸의 값 입력받고
            wall[i] = sc.nextInt();
        }

        for(int i = 1; i < W - 1; i++) {				//1 ~ W-2인 i번째 사이의 값 1개씩 확인
            int left = wall[i];
            int right = wall[i];

            for(int j = 0; j < i; j++) { 				//기준 i인덱스로 최대 좌측값
                left = Math.max(wall[j], left);
            }

            for(int j = i + 1; j < W; j++) {			//기준 i인덱스로 최대 우측값
                right = Math.max(wall[j], right);
            }

            min = Math.min(right, left);				//이 좌,우측값의 최댓값은 의미X
            value += Math.abs(min - wall[i]);			//최솟값과 해당 wall[i]의 차를 구하고 절댓값을 씌워 +answer
        }
        System.out.println(answer);
    }
}

// 1. 2차원 배열 전체 크기에서 뺴면서 값 구하기
// 2. 값을 확인하면서 순차적으로 결과값 더해주기