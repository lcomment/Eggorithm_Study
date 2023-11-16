import java.io.*;
import java.util.*;

class Swea_fishBread{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= test; test_case++) {
            String[] data = br.readLine().split(" ");
            int[] people = new int[Integer.parseInt(data[0])];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<people.length; i++) {
                people[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(people);

            int time = 0;
            int fish = 0;
            boolean flag = false;
            int i= 0;
            while(i!=people.length) {
                time += Integer.parseInt(data[1]);
                fish += Integer.parseInt(data[2]);
                while(true) {
                    if(people[i] < time) {
                        flag = true;
                        break;
                    }
                    else if(people[i] == time && fish == 0) {
                        flag = true;
                        break;
                    }
                    else if(people[i] == time && fish != 0) {
                        fish--;
                        i++;
                    }
                    else if(people[i] > time && fish == 0) {
                        break;
                    }
                    else if(people[i] > time && fish != 0) {
                        fish--;
                        i++;
                    }
                    if(i == people.length)	 break;
                }
                if(flag) {
                    break;
                }
            }
            if(flag) {
                System.out.println("#" + test_case +" Impossible");
            }
            else if(!flag)	System.out.println("#" + test_case + " Possible");
        }
    }
}
