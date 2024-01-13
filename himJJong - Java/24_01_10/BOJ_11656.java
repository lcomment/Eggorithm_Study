import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_11656 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String tmp = br.readLine();

        for(int i=0; i<tmp.length(); i++){
            list.add(tmp.substring(i, tmp.length()));
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
