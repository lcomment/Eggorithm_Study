import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17250 {
    static int data[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] NM = new int[2];

        NM[0] = Integer.parseInt(st.nextToken());
        NM[1] = Integer.parseInt(st.nextToken());

        data = new int[NM[0]+1][2];

        for(int i=1; i<=NM[0]; i++){
            st = new StringTokenizer(br.readLine());
            data[i][0] = i;
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        //연결 데이터 돌면서 해당 행성 값 체크해주기

        for(int i=0; i<NM[1]; i++){
            st = new StringTokenizer(br.readLine());

            int[] connectData = new int[2];
            connectData[0] = Integer.parseInt(st.nextToken());
            connectData[1] = Integer.parseInt(st.nextToken());

            int sum = connectNode(connectData[0],connectData[1]); //부모노드 합치고, 행성 합 갱신
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static int connectNode(int tmpA, int tmpB) {
        int sum = findParent(tmpA, tmpB);
        return sum;
    }

    private static int findParent(int tmpA, int tmpB) {
        int a = checkNode(tmpA);
        int b = checkNode(tmpB);

        if(a > b) {
            data[a][0] = b;
            data[b][1] += data[a][1];
            return data[b][1];
        }
        else if(a < b){
            data[b][0] = a;
            data[a][1] += data[b][1];
            return data[a][1];
        }
        else{
            return data[a][1];
        }
    }

    private static int checkNode(int planet) {

        if(data[planet][0] == planet) return planet;
        else return data[planet][0] = checkNode(data[planet][0]);
    }
}