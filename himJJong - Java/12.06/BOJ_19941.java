import java.io.*;
import java.util.*;

public class BOJ_19941 {
    static boolean[] check;
    static List<String> list;
    static int N;
    static int M;
    static int answer = 0;
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();

        // stream 사용으로 N과 M 데이터 입력
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0];
        M = NM[1];

        check = new boolean[N];             //햄버거 체크해줄 boolean
        String data = br.readLine();
        for(int i=0 ; i<N; i++){            //list에 데이터 하나씩 넣어주면서, "P"인 데이터위치의 boolean은 true로 미리 변경
            list.add(String.valueOf(data.charAt(i)));
            if(list.get(i).equals("P")) check[i] = true;
        }

        while(index != N){                  //햄버거 개수만큼 다 확인할건데
            int num = 0;
            if(list.get(index).equals("P")) {       //해당 list의 배열값이 "P" 라면
                for(int i=index-M ; i<=index+M; i++){
                    if(i >= 0 && i <=N-1 && !check[i]) {    //i값을 범위내로 체킹해주며 false라면
                        check[i]=true;
                        answer++;
                        break;
                    }
                }
            }
            index++;
        }

        System.out.println(answer);
    }
}