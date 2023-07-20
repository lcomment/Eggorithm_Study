import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_boat {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        int[] people = {30,30,30};
        int limit = 100;
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length-1;
        int sum = 0;
        while(left <= right){
            int tmp = people[left] + people[right];

            if(tmp + sum < 100){
                sum+= people[left];
                left++;
            }

            else if(tmp + sum == 100){
                left++;
                right--;
                sum = 0;
                answer++;
            }

            else{
                right--;
                sum = 0;
                answer += 1;
            }
        }

        if(sum !=0) System.out.println(answer+1);
        else System.out.println(answer);
    }
}
