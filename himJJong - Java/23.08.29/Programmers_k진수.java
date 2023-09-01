import java.util.*;
public class Programmers_k진수 {
    public static void main(String[] args) {
        System.out.println(solution(11111,2));
    }
    static public int solution(int n, int k) {
        int answer = 0;

        String tmp = Integer.toString(n,k);
        String[] cur = tmp.split("0");

        for(int i=0; i<cur.length; i++){
            if(cur[i].equals(""))  continue;
            long data = Long.parseLong(cur[i]);
            if(isPrime(data)){
                answer++;
            }
        }
        return answer;
    }
    static public boolean isPrime(long num){
        if(num <2)   return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}