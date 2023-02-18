import java.util.*;
import java.io.*;

public class BOJ_18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(br.readLine());
        int[] data;

        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(data);

        int median = (house-1) / 2;
        System.out.println(data[median]);
    }
}