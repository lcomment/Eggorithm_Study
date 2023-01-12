import java.io.*;
import java.util.*;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NM[0];
        int M = NM[1];

        int[] data = new int[N];        // data가 들어있는 배열
        int maxnum = 0;                 // data 배열의 최댓값을 찾아 그만큼의 check 배열의 size를 부여해주기 위함

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            maxnum = Math.max(data[i], maxnum);
        }
        int[] check = new int[maxnum + 1];       // 값을 체크해주기 위해 만든 배열

        int start = 0;
        int end = 0;
        int max = 0;

        while(end < data.length){
            while(check[data[end]] < M){
                check[data[end]]++;
                end++;
                if(end > data.length-1) break;
            }
            int count = end - start;
            max = Math.max(max,count);
            check[data[start]]--;
            start++;
        }
        System.out.println(max);
    }
}

/*
import java.io.*;
import java.util.*;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NM[0];
        int M = NM[1];

        int[] data = new int[N];        // data가 들어있는 배열
        int maxnum = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<data.length; i++){
            data[i] = Integer.parseInt(st.nextToken());
            maxnum = Math.max(data[i],maxnum);
        }
        int[] check = new int[maxnum+1];       // 값을 체크해주기 위해 만든 배열

        int index = 0;  // 끝까지 조회하기 위해 만든 변수
        int count = 0;  // 값의 길이를 체크하기 위한 변수
        int max = 0;    // 값의 최대값을 구하기 위한 변수
        int remember = 0;

        while(remember != data.length){
            if(check[data[index]]<M){
                check[data[index]]++;
                count++;
            }
            else {
                max = Math.max(max,count);
                count = 0;
                remember++;
                index = remember-1;
                Arrays.fill(check,0);
            }
            index++;
            if(index == N) break;
        }

        System.out.println(Math.max(max,count));

    }
}*/