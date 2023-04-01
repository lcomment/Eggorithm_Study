import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2661 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        backtracking("");
    }

    public static void backtracking(String str){

        for(int i=1;i<=3;i++){
            if(isGoodSeq(str)){
                if(str.length()==N){
                    System.out.println(str);
                    System.exit(0);
                }
                backtracking(str+i);
            }
        }
    }

    public static boolean isGoodSeq(String str){
        int level=str.length()/2;
        for(int i=1;i<=level;i++){
            if(str.isEmpty()) return true;

            String front_str = str.substring(str.length()-i-i, str.length()-i);
            String behind_str = str.substring(str.length()-i);
            if(front_str.equals(behind_str)) return false;
        }
        return true;
    }
}