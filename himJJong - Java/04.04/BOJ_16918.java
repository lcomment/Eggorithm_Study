import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int R = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int N = Integer.parseInt(inputs[2]);

        char[][] map = new char[R][C];
        int[][] bombtime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='O'){
                    bombtime[i][j] = 3; // 폭탄이 터질 시간 (놓인 시간 + 3)
                }
            }
        }

        int time = 0;
        int[] mi = {1, -1, 0, 0};
        int[] mj = {0, 0, 1, -1};

        while(time++ < N) {
            if(time%2==0) {
                // 비어있는 모든 칸에 폭탄을 설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time+3;
                        }
                    }
                }
            }else if(time%2==1) {
                // 시간이 다 된 폭탄 터트림
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombtime[i][j] == time) {
                            map[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int ni = i + mi[d];
                                int nj = j + mj[d];

                                if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                                // 이번에 터트려야 할 폭탄을 연쇄반응으로 미리 터트리게 되면
                                // 미리 터트린 폭탄의 주변 폭탄을 연쇄시킬 수 없다. 그래서 bombtime을 확인!
                                if(map[ni][nj]=='O' && bombtime[ni][nj] != time) {
                                    map[ni][nj] = '.';
                                    bombtime[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }

    }
}