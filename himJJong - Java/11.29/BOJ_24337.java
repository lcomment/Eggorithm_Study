import java.io.*;
import java.util.*;

public class BOJ_24337 {
    static Deque<Integer> dq;
    static int building;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        dq = new ArrayDeque<>();

        building = Integer.parseInt(st.nextToken());    //빌딩 개수
        int gahui = Integer.parseInt(st.nextToken());   //가희
        int danbi = Integer.parseInt(st.nextToken());   //단비
        int flag = 0;

        if(gahui == 1 || danbi == 1){                   //flag를 두어 가희와 단비가 1 1 일때 따로 처리하기 위해
            flag = 1 ;
        }

        if (gahui+danbi == 2){                          //만약 1 1 조건일때
            for(int i=0; i<building; i++){
                dq.addFirst(1);
            }
        }

        else if(gahui+danbi <= building+1 && flag == 1){    // 가희와 단비 중 1을 포함할 때
            oneContains(gahui,danbi);
        }
        else if(gahui+danbi <= building+1 && flag == 0){    // 가희와 단비 중 1을 포함하지 않을 때
            notOneContains(gahui,danbi);
        }
        else System.out.print(-1);                          // 나머지 입력 -1 출력

        for (Integer elem : dq) {
            answer.append(elem).append(" ");
        }

        System.out.print(answer.toString().trim());
    }

    private static void notOneContains(int gahui, int danbi) {  // 가희 단비 둘 다 1을 가지지 않을 때 메서드
        if (gahui >= danbi) {                            //가희가 단비보다 값이 크거나 같다면
            for (int i = gahui; i >= 1; i--) {
                dq.addFirst(i);
            }
            for (int i = danbi - 1; i >= 1; i--) {       //ex 6 3 2
                dq.addLast(i);                           // 1 1 1 2 3 1
            }                                            // 가희와 단비를 순차적으로 뽑아내고
            int blank = building - dq.size();
            while (blank-- > 0) {                        //blank만큼 맨 앞으로 1 추가
                dq.addFirst(1);
            }
        }

        else {
            for (int i = danbi; i >= 1; i--) {
                dq.addLast(i);
            }                                            //ex 6 2 3
            for (int i = gahui - 1; i >= 1; i--) {       //1 1 1 3 2 1
                dq.addFirst(i);
            }
            int blank = building - dq.size();
            while (blank-- > 0) {
                dq.addFirst(1);
            }
        }
    }

    private static void oneContains(int gahui, int danbi) { // 가희와 단비 중 1을 가질 때 메서드
        int blank;

        if(gahui != 1){                         // ex) 5 4 1
            blank = building-gahui;
            for(int i=1; i<=gahui; i++){
                dq.addLast(i);
            }                                   // 이쪽은 어차피 앞 쪽 부터이기에, blank만큼 앞에 1 추가
            while(blank -- >0){
                dq.addFirst(1);
            }
        }

        if(danbi != 1){                         // ex) 5 1 4
            blank = building-danbi;
            for(int i=danbi; i>=1; i--){
                dq.addLast(i);
                if(i==danbi) {                  // 4가 들어가고, blank만큼 1을 넣은 후 나머지 3 2 1 추가
                    while(blank -- >0){
                        dq.addLast(1);
                    }
                }
            }
        }

    }
}