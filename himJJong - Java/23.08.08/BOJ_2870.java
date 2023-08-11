import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.math.BigInteger;

public class BOJ_2870{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, n = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        ArrayList<BigInteger> paper = new ArrayList<>();
        String[] line;
        for(i=0;i<n;i++){
            line = br.readLine().split("\\D");
            for(j=0;j<line.length;j++) {
                if (!line[j].equals("")) {
                    paper.add(new BigInteger(line[j]));
                }
            }
        }
        paper.sort(null);

        for(i=0;i<paper.size();i++) {
            res.append(paper.get(i)).append("\n");
        }

        System.out.println(res);
    }
}