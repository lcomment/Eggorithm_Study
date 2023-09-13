import java.util.*;

public class codeTree_btk {
    static int N;
    static int answer = 0;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        check = new int[N];

        backTracking(0);
        System.out.println(answer);
    }
    private static void backTracking(int num){
        if(num == N){
            if(check2()){
                answer++;
            }
            return;
        }

        for(int i=1; i<=4; i++){
            check[num] = i;
            backTracking(num+1);
        }
    }

    private static boolean check2(){
        for(int i=0; i<N; i++){
            int tmp = check[i]-1;
            while(tmp-- >0){
                if(i+1<N && check[i] == check[i+1]){
                    i++;
                }
                else    return false;
            }
        }
        return true;
    }
}