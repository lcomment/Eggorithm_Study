import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeTree_Hashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int goal1 = scanner.nextInt();
        int goal2 = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        long countgoal1 = 0;
        long countgoal2 = 0;

        for(int i=0; i<n; i++){
            int checkGoal1 = goal1 - a[i];
            int checkGoal2 = goal2 - a[i];

            countgoal1 += countMap.getOrDefault(checkGoal1,0);
            countgoal2 += countMap.getOrDefault(checkGoal2,0);

            countMap.put(a[i],countMap.getOrDefault(a[i],0)+1);
        }
        System.out.println(countgoal1+" "+countgoal2);
    }
}
