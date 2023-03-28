import java.io.*;
import java.util.*;

public class BOJ_1644 {
    static boolean prime[] = new boolean[4000001];
    static ArrayList<Integer> prime_numbers = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        prime[0] = prime[1] = true;

        for(int i=2; i*i<=N; i++){
            if(!prime[i]){  // prime[i]가 소수라면
                for(int j=i*i; j<=N; j+=i) {    // prime[j] 소수가 아닌 표시
                    prime[j]=true;
                }
            }
        }

        for(int i=1; i<=N;i++){
            if(!prime[i]) prime_numbers.add(i);
        }
        int start = 0;
        int end = 0;

        if(N <= 1) {
            System.out.println(0);
            System.exit(0);
        }
        while(start <= end){
            if(end < prime_numbers.size()){
                int sum = 0;
                for(int i=start; i<=end; i++){
                    sum += prime_numbers.get(i);
                }
                if(sum > N){
                    start++;
                }
                else if(sum < N){
                    end++;
                }
                else {
                    answer++;
                    end++;
                }
            }
            else break;
        }

        System.out.println(answer);
    }
}
