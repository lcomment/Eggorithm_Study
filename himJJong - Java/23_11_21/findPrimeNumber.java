import java.util.*;
class findPrimeNumber {
    static int answer =0;
    static HashSet<Integer> h = new HashSet<>();
    public int solution(String numbers) {
        boolean[] flag = new boolean[10000000];
        boolean[] duplicate = new boolean[10000000];

        for(int i=2; i*i<10000000; i++){
            if(!flag[i]){
                for(int j = i*i; j<10000000 ; j+= i){
                    flag[j] = true;
                }
            }
        }
        flag[0] = true;
        flag[1] = true;

        String[] check = numbers.split("");
        for(int i=1; i<=check.length; i++){
            String[] result = new String[i];
            boolean[] check2 = new boolean[numbers.length()];
            btk( check, flag, result, 0, i, check2);
        }

        return answer;
    }

    private static void btk( String[] check, boolean[] flag, String[] result, int index, int goal, boolean[] check2){
        if(index == goal){
            int sum = 0;

            for(int i=0; i<result.length; i++){
                sum += Integer.parseInt(result[i]) * Math.pow(10,result.length-(i+1));
            }
            if(!h.contains(sum) && !flag[sum]){
                h.add(sum);
                answer++;
            }
            return;
        }

        for(int i=0; i<check.length; i++){
            if(!check2[i]){
                check2[i] = true;
                result[index] = check[i];
                btk(check, flag, result, index+1, goal, check2);
                check2[i] = false;
            }
        }
    }
}