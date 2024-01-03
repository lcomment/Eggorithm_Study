import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2816 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        boolean flag1 = false;
        boolean flag2 = false;

        int index = 0;
        while(!flag1){
            if(list.get(index).equals("KBS1")){
                while(index != 0){
                    String tmp = list.get(index-1);
                    list.set(index-1, list.get(index));
                    list.set(index, tmp);
                    index --;
                    sb.append("4");
                }
                flag1 = true;
            }
            else{
                sb.append("1");
                index++;
            }
        }

        while(!flag2){
            if(list.get(index).equals("KBS2")){
                while(index != 1){
                    index --;
                    sb.append("4");
                }
                flag2 = true;
            }
            else{
                sb.append("1");
                index++;
            }
        }

        System.out.println(sb);
    }
}
