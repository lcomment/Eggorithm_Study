import java.io.*;
import java.util.*;


public class BOJ_2512 {
    static int[] NM;
    static long goal;
    static int count;
    static long memory = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count =Integer.parseInt(br.readLine());
        NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        goal = Long.parseLong(br.readLine());
        Arrays.sort(NM);

        long answer;
        long start = 0;
        long end = NM[NM.length-1];
        long checkdata = 0;

        while(true) {
            long tmp = 0;
            answer = (start + end) /2;
                                                        // 이쪽은 answer값이 끝에 도달해 계속 반복될 때를 위해 넣은 것
            if(answer == checkdata && memory < goal){   // answer값은 start와 end 중앙값, checkdata는 이전 answer 중앙값
                answer += 1;                            // tmp이전 전체 합 값이 memory,  goal 도달해야하는 값
            }
            if(answer == checkdata && memory > goal){
                answer -=1 ;
            }
                                                        // 이쪽은 넣은 데이터를 비교하면서 값 축척
            for(int i=0; i<count; i++){
                if(NM[i] >= answer) tmp += answer;
                else tmp += NM[i];
            }

            if(tmp > goal){                             // 축척한 tmp값이 목표한 goal 보다 크다면 위치 인덱스 변경
                end = answer;
            }
            else if(tmp < goal){                        // 축척한 tmp값이 목표한 goal 보다 작다면 위치 인덱스 변경
                start = answer;
            }
            else {
                System.out.println(answer);
                break;
            }

            if(checkCompare(answer) && tmp < goal){     // 예제 1번을 위해 만든 것
                System.out.println(answer);
                break;
            }
            // 아래는 값이 한쪽 끝으로 갔을 때, goal과 축척값을 비교해 필요한 값 추가

            if(start == NM[NM.length-1] && end == NM[NM.length-1] && tmp <= goal){
                System.out.println(NM[NM.length-1]);
                break;
            }
            if(start == NM[0] && end == NM[0] && tmp > goal) {
                start -= 1;
                end -= 1;
            }
            if(start == NM[0] && end == NM[0] && tmp <= goal){
                System.out.println(answer);
                break;
            }

            checkdata = answer;                                   // start와 end의 중앙값을 checkdat에 저장 위에서 비교하기 위해
            memory = tmp;                                         // 축척값을 static 변수인 memory에 저장
        }
    }
    private static boolean checkCompare(long answer) {
        long nextValue = answer + 1;
        long tmp = 0;
        for(int i=0; i<count; i++){
            if(NM[i] >= nextValue) tmp += nextValue;
            else tmp += NM[i];
        }
        return tmp > goal;
    }
}

/*
import java.io.*;
        import java.util.*;


public class Main {
    static int[] NM;
    static long goal;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count =Integer.parseInt(br.readLine());
        NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        goal = Long.parseLong(br.readLine());
        Arrays.sort(NM);

        long start = 0;
        long end = NM[NM.length-1];

        while(start <= end){
            long center = (start+end)/2;
            long result = 0;
            for(int i=0; i<count; i++){
                if(NM[i]>center) result+=center;
                else result+=NM[i];
            }

            if(result<=goal) start = center+1;
            else end = center-1;
        }
        System.out.println(end);
    }
}*/
