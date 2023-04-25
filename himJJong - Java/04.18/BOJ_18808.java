import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18808 {
    static int[] NM;
    static int[][] paper;
    static boolean[][] stickerVisted;   // 각각 스티커 붙였을 때 가능한지 확인하는 방문 배열
    static boolean[][] realVisited;     // 전체적으로 스티커를 붙힌 판의 방문 배열
    static boolean[] flag;              // 각각 스티커를 붙였는지 체크하는 배열
    static List<int[][]> stickerList = new ArrayList<>();   // 스티커 담는 리스트
    static int count;                                       // 스티커를 붙인 수를 체크해주는 변수
    static int[] checkComparePoint;                         // 스티커의 1 개수
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        flag = new boolean[NM[2]];
        paper = new int[NM[0]][NM[1]];
        stickerVisted = new boolean[NM[0]][NM[1]];
        realVisited = new boolean[NM[0]][NM[1]];
        checkComparePoint = new int[NM[2]];
        int answer = 0;

        for(int i=0; i<NM[2]; i++){     //스티커 데이터
            st = new StringTokenizer(br.readLine());
            int num = 0;

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[row][col];

            for(int j=0; j<row; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<col ;k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                    if(sticker[j][k] == 1) num++;
                }
            }
            checkComparePoint[i] = num;
            stickerList.add(sticker);
        }

        int index = 0;
        int spinCount = 0;

        while(index != NM[2]){
            boolean check = false;

            Loop:                                                           // 스티커가 움직일 수 있는 좌표 전체 확인
            for(int i=0; i<NM[0] - stickerList.get(index).length +1; i++){
                for(int j=0; j< NM[1] - stickerList.get(index)[0].length +1; j++){
                    if(index < NM[2] && attachCheck(i,j, stickerList.get(index)) && count == checkComparePoint[index]){
                        check = true;
                        checkVisted();              // 스티커 붙였다면, spin하지 않게 check true로 변경
                        flag[index] = true;         // 다음 스티커를 위해 index++
                        index++;                    // 회전 수와 스티커 붙인 개수 초기화
                        spinCount = 0;              // 전체 도화지에 스티커 배열 붙인것 적용
                        count=0;                    // 붙였다면 다시 처음부터 돌아야 하기 때문에 break Loop
                        break Loop;
                    }
                    count=0;
                    initStickerVisited();           // 모든 좌표에 대해 실행할 때마다 스티커 붙일 수 있는지 체크해주는 boolean 배열 초기화
                }
            }
            if(spinCount == 3 && !flag[index]) {        // 다 회전 한 후에도 붙힐곳이 없다면 버리기
                flag[index] = true;
                index++;
                spinCount = 0;
                continue;
            }
            if(index < NM[2] && !flag[index] && !check) {   // 아직 붙히지 못했다면, 90도 회전
                spin(stickerList.get(index),index);
                spinCount++;
            }

        }

        for(int i=0; i<NM[0]; i++){                         // 최종 도화지의 true값 계산
            for(int j=0; j<NM[1]; j++){
                if(realVisited[i][j]) answer++;
            }
        }
        System.out.println(answer);
    }

    private static void initStickerVisited() {
        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                stickerVisted[i][j] = false;
            }
        }
    }

    private static void checkVisted() {
        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(stickerVisted[i][j]) realVisited[i][j] = true;
            }
        }
    }

    private static void spin(int[][] sticker, int index) {
        int[][] spinSticker = new int[sticker[0].length][sticker.length];
        for (int i = 0; i < sticker.length ; i++) {
            for(int j=0; j<sticker[0].length;j++){
                spinSticker[j][sticker.length-1-i] = sticker[i][j];
            }
        }
        stickerList.add(index,spinSticker);
        stickerList.remove(index+1);
    }

    private static boolean attachCheck(int x, int y, int[][] sticker ) {
        for(int i=0; i< sticker.length; i++){
            for(int j=0; j< sticker[0].length; j++){
                if(sticker[i][j] == 1) {
                    stickerVisted[i+x][j+y] = true;
                }
            }
        }

        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(!realVisited[i][j] && stickerVisted[i][j]) count++;
            }
        }

        return true;
    }
}
