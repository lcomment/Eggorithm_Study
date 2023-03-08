import java.io.*;
import java.util.Arrays;
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

        //data[i][0] 부모 노드의 값을, data[i][1] 은하의 행성 개수
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
    //parentA 해당 선택의 값에 대한 부모노드
    //parentB 해당 선택의 값에 대한 부모노드
    // connectionData 연결했는지 확인하는 데이터
    private static int connectNode(int tmpA, int tmpB) {
        if(findParent(tmpA,tmpB)==1){
        }
        else{
            unionParent(tmpA,tmpB);        //data[tmpA][0] = data[tmpB][0];
        }
        return data[checkNode(tmpA)][1];
    }

    private static int findParent(int tmpA, int tmpB) {
        int a = checkNode(tmpA);
        int b = checkNode(tmpB);

        if(a==b) return 1;
        else return 0;
    }

    private static void unionParent(int tmpA, int tmpB) {
        int a = data[checkNode(tmpA)][0];
        int b = data[checkNode(tmpB)][0];

        if(a<b) {
            data[a][1] = data[a][1] + data[b][1];
            for(int i=0; i<data.length; i++) {
                if (data[i][0] == data[tmpB][0]) {
                    data[i][0] = a;
                }
            }
            data[tmpB][0] = data[tmpA][0];
        }
        else {
            data[b][1] = data[a][1] + data[b][1];
            for(int i=0; i<data.length; i++) {
                if (data[i][0] == data[tmpA][0]) {
                    data[i][0] = b;
                }
            }
            data[tmpA][0] = data[tmpB][0];
        }
    }

    //부모 노드 체크
    private static int checkNode(int planet) {

        if(data[planet][0] == planet) return planet;
        return checkNode(data[planet][0]);
    }
}