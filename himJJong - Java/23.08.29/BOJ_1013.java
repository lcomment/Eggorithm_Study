import java.util.*;

public class BOJ_1013 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String vega = "(100+1+|01)+";
        int t = scan.nextInt();

        for(int i = 0; i < t; i++) {
            String spread = scan.next();
            if(spread.matches(vega)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
