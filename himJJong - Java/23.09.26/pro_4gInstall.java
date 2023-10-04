import java.util.*;

public class pro_4gInstall {
    static int n = 16;
    static int[] stations = {9};
    static int w= 2;
    public static void main(String[] args) {
        int answer = 0;
        int si = 0;
        int position = 1;
        while(position <= n) {
            if(si < stations.length && position >= stations[si] - w) {
                position = stations[si] + w + 1;
                si ++;
            }
            else {
                answer += 1;
                position += (w*2) + 1;
            }
        }
        System.out.println(answer);
    }
}