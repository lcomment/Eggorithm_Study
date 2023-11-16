import java.io.*;
import java.util.*;

class Swea_shuffle{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= test; test_case++) {
            sb = new StringBuilder();
            int count = Integer.parseInt(br.readLine());
            String[] tmp = br.readLine().split(" ");

            if(count % 2 == 0) {
                int shuffleIndex = count/2;
                for(int i=0; i<count; i++) {
                    if(i % 2 == 0) {
                        sb.append(tmp[i/2]).append(" ");
                    }
                    else {
                        sb.append(tmp[shuffleIndex]).append(" ");
                        shuffleIndex++;
                    }
                }

            }

            else {
                int shuffleIndex = count/2 + 1;
                for(int i=0; i<count-1 ; i++) {
                    if(i % 2 == 0) {
                        sb.append(tmp[i/2]).append(" ");
                    }
                    else {
                        sb.append(tmp[shuffleIndex]).append(" ");
                        shuffleIndex++;
                    }
                }
                sb.append(tmp[count/2]);
            }

            System.out.println("#" + test_case + " " + sb);
        }
    }
}
