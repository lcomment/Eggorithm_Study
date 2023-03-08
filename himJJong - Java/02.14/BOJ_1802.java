import java.io.*;

public class BOJ_1802 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++){
            String[] val = br.readLine().split("");

            if(val.length == 1){
                sb.append("YES");
                sb.append("\n");
                continue;
            }

            else if(val.length > 1 && check(val)){
                sb.append("YES");
                sb.append("\n");
                continue;
            }
            sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    //3 -> 1
    //5 -> 1
    //7 -> 3
    //9 -> 1
    //11 -> 3
    //13 - > 1
    // 0 0 0 0 0 0 [0] 0 0 0 0 0 0
    private static boolean check(String[] val) {
        int count = 0;
        for(int i=0; i<val.length/2; i++){      // 각각에 맞는 쪽수의 합 체크
            if(Integer.parseInt(val[i]) +Integer.parseInt(val[val.length-(i+1)]) == 1 ){
                count++;
            }
            else return false;
        }
        if(count != 1 && count%2 == 1){        // 중점을 기준으로 왼쪽, 오른쪽 범위 홀수 체크와 1이 아닌지 체크 후 재귀문
            String[] leftVal = new String[val.length/2];
            String[] rightVal = new String[val.length/2];

            for(int i=0; i<val.length/2; i++){
                leftVal[i] = val[i];
            }
            int index = 0;
            for(int i=val.length/2+1; i<val.length; i++){
                rightVal[index] = val[i];
                index++;
            }
            if(check(leftVal) && check(rightVal)){
                return true;
            }
            else return false;
        }
        return true;
    }
}
