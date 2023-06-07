import java.util.Arrays;
import java.util.Stack;

public class programmers_behindBig {
    public static void main(String[] args) {
        int[] numbers = {2,3,3,5};
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();

        for(int i=numbers.length-1; i>=0; i--){
            while(!s.isEmpty()){
                if(s.peek() > numbers[i]){
                    answer[i] = s.peek();
                    break;
                }else{
                    s.pop();
                }
            }
            if(s.isEmpty()){
                answer[i] = -1;
            }
            s.push(numbers[i]);
        }
    }
}
