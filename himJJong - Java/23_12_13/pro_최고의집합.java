import java.util.*;
public class pro_최고의집합 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(2,2));
    }
    static class Solution {
        public static int[] solution(int n, int s) {
            int[] answer;
            List<Integer> list = new ArrayList<>();
            if(s < n){
                answer = new int[1];
                answer[0] = -1;
                return answer;
            }

            answer = new int[n];

            for(int i=0; i<n; i++){
                answer[i] = s / (n-i);
                s -= answer[i];
            }
            return answer;
        }
    }
}
