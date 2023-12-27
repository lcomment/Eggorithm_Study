import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int val = 1;
        int index = 0;
        while(true){
            if(index == s.length()) break;
            if(String.valueOf(val).contains(String.valueOf(s.charAt(index)))){
                String[] check = String.valueOf(val).split("");
                for(int i=0; i<check.length; i++) {
                    if(index == s.length()){
                        System.out.println(val);
                        System.exit(0);
                        break;
                    }
                    if (check[i].equals(String.valueOf(s.charAt(index)))) {
                        index++;
                    }
                }
                val++;
            }
            else val++;
        }
        System.out.println(val-1);
    }
}
