import java.io.*;
import java.util.*;

public class BOJ_1748 {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for(int i=1;i<=n;i*=10)
            ans+=(n-i+1);
        System.out.println(ans);
    }
}
