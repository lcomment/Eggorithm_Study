import java.util.*;
import java.io.*;

public class BOJ_7490 {
    static int N;
    static List<String> ans;
    static String op[] = {"+", "-", " "};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i=1; i<=count; i++){
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();
            dfs(1,"1");
            Collections.sort(ans);
            for(String result : ans){
                System.out.println(result);
            }
            System.out.println();
        }
    }

    private static void dfs(int num, String s) {
        if(N == num){
            String express = s.replaceAll(" ", "");
            if(cal(express))
                ans.add(s);
            return;
        }
        for(int i=0; i<3; i++){
            dfs(num+1, s+op[i]+Integer.toString(num+1));
        }
    }

    private static boolean cal(String express) {
        StringTokenizer st = new StringTokenizer(express, "-|+",true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreElements()){
            String s = st.nextToken();
            System.out.println(s);
            if(s.equals("+")){
                sum += Integer.parseInt(st.nextToken());
            }
            else{
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        if(sum == 0)
            return true;
        return false;
    }
}