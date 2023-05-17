import java.util.*;
import java.io.*;

public class ssafy_possibleScore{
    static int n,t;
    static int[] score;
    static Set<Integer> s;
    static ArrayList<Integer> arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        t=sc.nextInt();
        for (int tc = 1; tc <=t; tc++) {
            n=sc.nextInt();
            score=new int[n];
            arr=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                score[i]=sc.nextInt();
            }
            s=new HashSet<>();
            s.add(0);
            arr.add(0);
            check(0);
            System.out.printf("#%d %d\n",tc,s.size());
        }
    }
    private static void check(int cnt) {
        if(cnt==n) {
            return;
        }
        int len=arr.size();
        for (int i = 0; i < len; i++) {
            if(!s.contains(arr.get(i)+score[cnt])) {
                s.add(arr.get(i)+score[cnt]);
                arr.add(arr.get(i)+score[cnt]);
            }
        }
        check(cnt+1);
    }
}