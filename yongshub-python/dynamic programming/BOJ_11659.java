import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11659 {
    static int[] NM;
    static int[] arr;
    static int[] sectionTotal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        NM = inputValues(br);
        arr = inputValues(br);
        sectionTotal = new int[NM[0] + 1];

        for(int i = 1; i <= arr.length; i++) {
            sectionTotal[i] = sectionTotal[i - 1] + arr[i - 1];
        }


        for(int i = 0; i < NM[1]; i++) {
            int[] input = inputValues(br);
            sb.append(sectionTotal[input[1]] - sectionTotal[input[0] - 1]).append("\n");
        }
        System.out.print(sb);
    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}