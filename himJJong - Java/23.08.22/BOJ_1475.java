import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1475 {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] N = sc.next().split("");

        boolean[] check = new boolean[10];
        int[] count = new int[10];

        for(int i=0; i<N.length; i++){
            if(Integer.parseInt(N[i]) == 6 || Integer.parseInt(N[i]) == 9){
                if(!check[6])   {
                    check[6] = true;
                    count[6]++;
                }
                else if(!check[9])  {
                    check[9] = true;
                    count[9]++;
                }
                else{
                    Arrays.fill(check,false);
                    check[Integer.parseInt(N[i])] = true;
                    count[Integer.parseInt(N[i])]++;
                }
            }
            else{
                if(!check[Integer.parseInt(N[i])]){
                    check[Integer.parseInt(N[i])] = true;
                    count[Integer.parseInt(N[i])]++;
                }
                else{
                    Arrays.fill(check,false);
                    check[Integer.parseInt(N[i])] = true;
                    count[Integer.parseInt(N[i])]++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<10; i++){
            max = Math.max(max, count[i]);
        }
        System.out.println(max);
    }
}
