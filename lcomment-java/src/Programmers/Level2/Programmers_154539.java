package Programmers.Level2;

import java.util.Stack;

public class Programmers_154539 {

    public int[] solution(int[] numbers) {
        int N = numbers.length;
        Stack<Integer> stack = new Stack<>();
        int[] save = new int[N];

        for(int i=0 ; i<N ; i++) {
            if(stack.isEmpty() || numbers[i] < numbers[i-1]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    save[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            save[stack.pop()] = -1;
        }

        return save;
    }
}
