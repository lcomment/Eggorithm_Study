import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2831 {
    static List<Integer> upMan = new ArrayList<>();
    static List<Integer> downMan = new ArrayList<>();
    static List<Integer> upGirl = new ArrayList<>();
    static List<Integer> downGirl = new ArrayList<>();

    static int N;
    static int answer;
    public static void main(String[] args)throws IOException {
        init();
        sortData();
        calUpManDownGirl();
        calDownManUpGirl();

        System.out.println(answer);
    }

    private static void calUpManDownGirl() {
        int s = 0;
        int e = 0;

        // +upMan & -downGirl
        while(s != upMan.size() && e != downGirl.size()){
            if(upMan.get(s) > Math.abs(downGirl.get(e))){
                e++;
            }
            else if(upMan.get(s) == Math.abs(downGirl.get(e))){
                e++;
            }
            else {
                answer ++;
                s++;
                e++;
            }
        }
    }

    private static void calDownManUpGirl() {
        int s_2 = 0;
        int e_2 = 0;

        // -downMan & +upGirl
        while(s_2 != downMan.size() && e_2 != upGirl.size()){
            if(Math.abs(downMan.get(s_2)) > upGirl.get(e_2)) {
                e_2++;
                s_2++;
                answer++;
            }
            else if (upGirl.get(e_2) == Math.abs(downMan.get(s_2))){
                s_2++;
            }
            else{
                s_2++;
            }
        }
    }

    private static void sortData() {
        Collections.sort(upMan);
        Collections.sort(upGirl);
        downMan.sort(Collections.reverseOrder());
        downGirl.sort(Collections.reverseOrder());
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        upMan = new ArrayList<>();
        downMan = new ArrayList<>();
        upGirl = new ArrayList<>();
        downGirl = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
            int data = Integer.parseInt(st.nextToken());

            if(data > 0) upMan.add(data);
            else if(data < 0) downMan.add(data);
        }


        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
            int data = Integer.parseInt(st.nextToken());

            if(data > 0) upGirl.add(data);
            else if(data < 0) downGirl.add(data);
        }
    }
}