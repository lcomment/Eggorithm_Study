import java.util.Scanner;

public class BOJ_6236 {
    static int N;
    static int M;
    static int[] moneyList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        moneyList = new int[N];
        int left = Integer.MIN_VALUE;
        int right = 0;

        for(int i=0; i<N; i++){
            moneyList[i] = sc.nextInt();
            right += moneyList[i];
            left = Math.max(left, moneyList[i]);
        }

        while(left <= right){
            int mid = (right + left)/2;
            int result = getCount(mid);

            if(result > M){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(right+1);
    }

    private static int getCount(int mid) {
        int sum = 0;
        int count = 0;
        for(int i=0; i<N; i++){
            if(sum + moneyList[i] <= mid){
                sum += moneyList[i];
            }
            else{
                sum = moneyList[i];
                count++;
            }
        }
        if(sum != 0)    count++;
        return count;
    }
}
