public class pro_124나라 {
    class Solution {
        public String solution(int n) {
            String answer = "";
            String[] index = {"4", "1", "2"};
            int num = n;

            while(num > 0) {
                int r = num % 3;
                num /= 3;

                if(r == 0){
                    num--;
                }

                answer = index[r] + answer;
            }
            return answer;
        }
    }
}
