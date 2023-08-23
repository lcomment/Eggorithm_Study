import java.io.*;
import java.util.Scanner;


public class BOJ_2564 {

    static int X, Y, stores, a, b, loc, ans;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), cnt = 0, police=0;
        int[] map = new int [k];
        for (int i = 0; i < k+1; i++) {
            int dir = sc.nextInt(), loc = sc.nextInt(), tmp=0;
            switch (dir) {
                case 1:
                    tmp = loc;
                    break;
                case 2:
                    tmp = n + m + n - loc;
                    break;
                case 3:
                    tmp = n + m + n + m - loc;
                    break;
                case 4:
                    tmp = n + loc;
                    break;
            }
            if(i<k)
                map[i]=tmp;
            else
                police=tmp;
        }

        for (int i = 0; i < k; i++) {
            int path1=Math.abs(police-map[i]);
            int path2 = 2*n+2*m-path1;
            cnt += Math.min(path1, path2);
        }
        System.out.println(cnt);
    }
}