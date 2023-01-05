package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7682 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = br.readLine()).equals("end")) {
            int x = countChar(input, 'X');
            int o = countChar(input, 'O');

            // O의 개수는 X의 개수보다 많을 수 없음
            // X의 개수는 (O의 개수 + 1)보다 많을 숭 없음
            if(o > x || x-o > 1) {
                System.out.println("invalid");
                continue;
            }

            map = new char[3][3];
            map[0] = input.substring(0,3).toCharArray();
            map[1] = input.substring(3,6).toCharArray();
            map[2] = input.substring(6,9).toCharArray();

            boolean checkX = checkValid('X');
            boolean checkO = checkValid('O');

            // 둘다 이길 순 없음
            if(checkO && checkX) {
                System.out.println("invalid");
                continue;
            }

            // 말이 꽉 찬 경우 (승자가 없어도 끝남 → 가능한 경우만 체크)
            if(x + o == 9){
                // O가 이길 수 없음 (O가 이기는 경우엔 꽉 차기 전에 끝남)
                if(checkO) System.out.println("invalid");
                // 둘다 못 이기거나 X가 이김
                else System.out.println("valid");
            }
            // 덜 끝난 경우
            else {
                // X가 이기려면 X는 선공이기 때문에 O의 개수보다 1 많아야 함
                if(checkX && x-o == 1) System.out.println("valid");
                // O가 이기려면 O는 후공이기 때문에 X의 개수와 같아야 함
                else if(checkO && x == o) System.out.println("valid");
                else System.out.println("invalid");
            }
        }
    }

    static boolean checkValid(char ch) {
        int cnt;

        // 가로 3칸 체크
        for(int i=0 ; i<3 ; i++) {
            cnt = 0;
            for(int j=0; j<3 ; j++) {
                if(map[i][j] == ch) cnt++;
            }
            if(cnt == 3)
                return true;
        }

        // 세로 3칸 체크
        for(int i=0 ; i<3 ; i++) {
            cnt = 0;
            for(int j=0; j<3 ; j++) {
                if(map[j][i] == ch) cnt++;
            }

            if(cnt == 3)
                return true;
        }

        // 대각선 3칸 체크
        if(map[0][0] == ch && map[1][1] == ch && map[2][2] == ch) return true;
        if(map[0][2] == ch && map[1][1] == ch && map[2][0] == ch) return true;

        return false;
    }

    static int countChar(String s, char ch) {
        return (int)s.chars()
                .filter(c -> c == ch)
                .count();
    }
}
