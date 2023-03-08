import java.util.*;
import java.io.*;

public class BOJ_1181 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        List<String> list = new LinkedList<>();
        int[] data = new int[count];

        for(int i=0; i<count; i++){
            String tmp = br.readLine();
            if(!list.contains(tmp)) {
                list.add(tmp);
            }
            else continue;
        }

        String[] result = new String[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else return o1.length() - o2.length();
            }
        });

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
