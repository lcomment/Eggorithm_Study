import java.util.*;

class pro_numberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int index = 0;
        for(int i=0; i<B.length; i++){
            if(B[i] > A[index]){
                answer++;
                index++;
            }
        }
        return answer;
    }
}