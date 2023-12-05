import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2590 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());
        int n4 = Integer.parseInt(br.readLine());
        int n5 = Integer.parseInt(br.readLine());
        int n6 = Integer.parseInt(br.readLine());

        int sum = n6; // 6

        sum += n5;
        n1 -= 11*n5; // 5

        sum += n4;
        n2 -= 5*n4;//4

        sum += (n3+3)/4;
        if(n3%4 == 1){
            n2 -= 5;
            n1 -= 7;
        }else if(n3%4 ==2){
            n2 -= 3;
            n1 -= 6;
        }else if(n3%4 ==3){
            n2 -= 1;
            n1 -= 5;
        } // 3

        if(n2 < 0){
            n1 += 4*n2;
        }

        if(n2 > 0){
            sum += (n2+8)/9;
            if(n2%9!=0){
                n1 -= (36 - (n2 %9)*4);
            }
        } //2

        if(n1 >0){
            sum += (n1+35)/36;
        } //1

        System.out.println(sum);

    }
}