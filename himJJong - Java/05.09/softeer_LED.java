import java.util.*;
import java.io.*;


public class softeer_LED {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++){
            int sum = 0;
            int index = 0;
            st = new StringTokenizer(br.readLine());

            String[] a = st.nextToken().split("");
            String[] b = st.nextToken().split("");

            int area = Math.max(a.length, b.length);

            for(int j=0; j<area; j++){
                int[] aData = new int[8];
                int[] bData = new int[8];

                if(index >= Math.abs(a.length - b.length)){
                    if(a.length > b.length){
                        int aIndex = index;
                        int bIndex = index - Math.abs(a.length-b.length);

                        check(aData,a[aIndex]);
                        check(bData,b[bIndex]);
                        index++;
                    }
                    else if(a.length < b.length){
                        int aIndex = index - Math.abs(a.length-b.length);
                        int bIndex = index;

                        check(aData,a[aIndex]);
                        check(bData,b[bIndex]);
                        index++;
                    }
                    else{
                        int aIndex = index;
                        int bIndex = index;

                        check(aData,a[aIndex]);
                        check(bData,b[bIndex]);
                        index++;
                    }
                    sum += compare(aData, bData);
                }

                else if(b.length > a.length){
                    check(bData,b[index]);
                    index++;

                    sum += turnOff(bData);
                }
                else if(a.length > b.length){
                    check(aData,a[index]);
                    index++;

                    sum += turnOff(aData);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int turnOff(int[] bData) {
        int result = 0;
        for(int i=0; i<8; i++){
            if(bData[i]==1) result++;
        }
        return result;
    }

    private static int compare(int[] aData, int[] bData) {
        int result = 0;

        for(int i=0; i<8 ; i++){
            if(aData[i] == bData[i])    continue;
            result += 1;
        }
        return result;
    }

    private static void check(int[] Data, String value) {
        int val = Integer.parseInt(value);
        if(val==0){
            Data[1] = 1;
            Data[2] = 1;
            Data[3] = 1;
            Data[5] = 1;
            Data[6] = 1;
            Data[7] = 1;
        }
        if(val == 1){
            Data[3] = 1;
            Data[6] = 1;
        }
        if(val == 2){
            Data[1] = 1;
            Data[3] = 1;
            Data[4] = 1;
            Data[5] = 1;
            Data[7] = 1;
        }if(val == 3){
            Data[1] = 1;
            Data[3] = 1;
            Data[4] = 1;
            Data[6] = 1;
            Data[7] = 1;
        }if(val == 4){
            Data[2] = 1;
            Data[4] = 1;
            Data[3] = 1;
            Data[6] = 1;
        }
        if(val == 5){
            Data[1] = 1;
            Data[2] = 1;
            Data[4] = 1;
            Data[6] = 1;
            Data[7] = 1;
        }
        if(val == 6){
            Data[1] = 1;
            Data[2] = 1;
            Data[4] = 1;
            Data[5] = 1;
            Data[6] = 1;
            Data[7] = 1;
        }
        if(val == 7){
            Data[1] = 1;
            Data[2] = 1;
            Data[3] = 1;
            Data[6] = 1;
        }
        if(val == 8){
            Data[1] = 1;
            Data[2] = 1;
            Data[4] = 1;
            Data[5] = 1;
            Data[6] = 1;
            Data[7] = 1;
            Data[3] = 1;
        }
        if(val == 9){
            Data[1] = 1;
            Data[2] = 1;
            Data[4] = 1;
            Data[6] = 1;
            Data[7] = 1;
            Data[3] = 1;
        }
    }
}