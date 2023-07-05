import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_12904 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        String S = br.readLine();
        String T = br.readLine();

        while(!S.equals(T)){
            String[] check = T.split("");
            if(T.length() == 0) {
                System.out.println(0);
                System.exit(0);
            }

            if(check[T.length()-1].equals("A")){
                check[T.length()-1] = "";
                T = "";
                for(int i=0; i<check.length; i++){
                    T+=check[i];
                }
            }
            else if(check[T.length()-1].equals("B")){
                check[T.length()-1] = "";
                T = "";
                for(int i=0; i< check.length; i++){
                    list.add(check[i]);
                }

                for(int i=list.size()-1; i>=0; i--){
                    T += list.remove(i);
                }
            }
        }

        System.out.println(1);
    }
}
