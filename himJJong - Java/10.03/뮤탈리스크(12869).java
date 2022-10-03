import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int [][][] DP =  new int[61][61][61];
    //뮤탈의 공격 경우의 수
    static int[][] attack = { {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static Integer[] scv = new Integer[3];	//scv 체력 저장 배열
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        //DP[][][] 초기화
        for(int i=0;i<61;i++){
            for(int j=0;j<61;j++)
                Arrays.fill(DP[i][j], Integer.MAX_VALUE);
        }
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //입력되는 SCV 체력 저장
        for(int i=0;i<N;i++)
            scv[i] = Integer.parseInt(st.nextToken());

        //SCV의 개수가 3개 미만인 경우 없는 SCV의 체력 0으로 초기화
        for(int i=N;i<3;i++)
            scv[i] = 0;

        bw.write(search(scv.clone(),0) + "");	//최소 공격횟수 구하기 및 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //뮤탈리스크 공격 경우의 수와 DP를 이용하여 최소 공격횟수 구하는 함수
    static int search(Integer[] scv, int count){
        boolean check = false;
        for(int i=0;i<N;i++){	//모든 SCV가 체력이 0일 때
            if(scv[i]!=0){
                check = true;
                break;
            }
        }
        if(!check){	//모든 SCV가 체력이 0일 때
            return count;
        }else{	//모든 SCV가 체력이 0이 아닐 때
            Arrays.sort(scv, Collections.reverseOrder());	//SCV 체력 내림차순 정렬
            //먼저 방문했을 경우 해당 값 반환
            if(DP[scv[0]][scv[1]][scv[2]]!=Integer.MAX_VALUE)
                return DP[scv[0]][scv[1]][scv[2]];

            //뮤탈리스크 공격 진행!
            for(int i=0;i<6;i++){
                Integer[] tempScv = new Integer[3];
                tempScv[0] = Math.max(scv[0] - attack[i][0], 0);
                tempScv[1] = Math.max(scv[1] - attack[i][1], 0);
                tempScv[2] = Math.max(scv[2] - attack[i][2], 0);
                //모든 공격의 최소값 DP의 저장
                DP[scv[0]][scv[1]][scv[2]] = Math.min(DP[scv[0]][scv[1]][scv[2]], search(tempScv, count+1));
            }
        }
        return DP[scv[0]][scv[1]][scv[2]];
    }
}
