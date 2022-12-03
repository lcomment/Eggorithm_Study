package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_21608 {
    static class Student {
        int num;
        int[] likes;
        Student(int num, int[] likes){
            this.num = num;
            this.likes = likes;
        }
    }
    static int N;
    static int[][] map, emptyMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        emptyMap = new int[N][N];  // 주변에 비어있는 칸의 개수
        map = new int[N][N];

        for(int i=0 ; i<N*N ; i++){
            // 0: 해당 학생 번호
            // 1~4: 해당 학생이 좋아하는 학생의 번호 리스트
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            students.add(new Student(input[0], Arrays.copyOfRange(input, 1, 5)));
        }

        initMap();

        for(Student student : students){
            int[][] likes = countLike(student, new int[N][N]);

            int maxEmpty = -1;
            int maxLike = -1;
            int row = -1;
            int col = -1;

            for(int r=0 ; r<N ; r++){
                for(int c=0 ; c<N ; c++){
                    if(map[r][c] != 0) continue;

                    if(likes[r][c] > maxLike){
                        maxLike = likes[r][c];
                        maxEmpty = emptyMap[r][c];
                        row = r;
                        col = c;
                    } else if(likes[r][c] == maxLike && emptyMap[r][c] > maxEmpty){
                        maxEmpty = emptyMap[r][c];
                        row = r;
                        col = c;
                    }
                }
            }

            map[row][col] = student.num;

            for(int d=0 ; d<4 ; d++){
                int nr = row + dr[d];
                int nc = col + dc[d];

                if(in(nr, nc)) emptyMap[nr][nc]--;
            }
        }

        System.out.println(countPreference());
    }

    static void initMap(){
        //  주변에 비어있는 칸의 개수 초기화
        for(int i=0 ; i<N ; i++){
            Arrays.fill(emptyMap[i], 4);
            for(int j=0 ; j<N ; j++){
                if(i==0 || i==N-1) emptyMap[i][j]--;
                if(j==0 || j==N-1) emptyMap[i][j]--;
            }
        }
    }

    static int[][] countLike(Student student, int[][] likeCount){
        for(int r=0 ; r<N ; r++){
            for(int c=0 ; c<N ; c++){
                // 이미 다른 학생의 자리인 경우 넘김
                if(map[r][c] != 0) continue;

                for(int d=0 ; d<4 ; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(!in(nr,nc)) continue;

                    for(int like : student.likes)
                        if(like == map[nr][nc]) likeCount[r][c]++;
                }
            }
        }

        return likeCount;
    }

    static int countPreference(){
        int count = 0;

        for(int r=0 ; r<N ; r++){
            for(int c=0 ; c<N ; c++){
                int cnt = 0;
                for(Student student : students){
                    if(student.num == map[r][c]){
                        for(int d=0;d<4;d++){
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if(!in(nr, nc)) continue;

                            for(int like : student.likes){
                                if(map[nr][nc] == like) cnt++;
                            }
                        }
                    }
                }
                count += Math.pow(10, cnt-1);
            }
        }

        return count;
    }

    static boolean in(int r, int c){
        return r >= 0 && c >= 0 && r <= N - 1 && c <= N - 1;
    }
}
