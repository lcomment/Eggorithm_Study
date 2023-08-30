import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_3273 {
    public static void main(String[] args)throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split(" ");
        int goal = Integer.parseInt(br.readLine());

        for(int i=0; i<tmp.length; i++){
            list.add(Integer.parseInt(tmp[i]));
        }

        Collections.sort(list);

        int left = 0;
        int right = list.size()-1;
        int answer = 0;

        while(left < right){
            int check = list.get(left) + list.get(right);

            if(check > goal){
                right--;
            }
            else if(check < goal){
                left++;
            }
            else{
                answer++;
                left++;
                right--;
            }
        }

        System.out.println(answer);
    }
}
