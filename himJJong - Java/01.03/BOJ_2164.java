import java.io.*;
import java.util.*;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int check = 0;

        List<Integer> list = new LinkedList<>();

        for(int i=1; i<=num; i++){
            list.add(i);
        }

        while(list.size()!=1){
            if(check%2 == 0) {
                list.remove(0);
                check++;
            }
            else {
                int tmp = list.remove(0);
                list.add(list.size(),tmp);
                check++;
            }
        }
        System.out.println(list.get(0));
    }
}