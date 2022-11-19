package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12100 {
	static int N;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		backtracking(0);
		System.out.println(max);
	}
	
	static void backtracking(int count) {
		if(count == 5) {
			// 가장 높은 수 저장 
			for(int[] m : map) {
				for(int num : m) {
					max = Math.max(num, max);
				}
			}
			return;
		}
		
        // 매개변수로 move한 배열 넘겼을 때 -> 오답 
		// 깊은 복사로 원복해줬을 때 -> 정답
		// 뭐가 차이인지 모르겠음,,,
		int copy[][] = new int[N][N];
        
        for(int i = 0; i < N; i++)
            copy[i] = map[i].clone();
        
        for(int i = 0; i < 4; i++) {
            move(i);
            backtracking(count+1);
            
            for(int a = 0; a < N; a++)
                map[a] = copy[a].clone();
        }
        
	}
	
    public static void move(int dir) {
    	int idx, save;
    	
        switch(dir) {
            // 상 
            case 0:
                for(int c=0 ; c<N ; c++) {
                    idx = 0;
                    save = 0;
                    for(int r=0 ; r<N ; r++) {
                    	// 숫자가 있을 때 
                        if(map[r][c] != 0) {
                        	// 저장된 값과 같으면 *2 
                            if(save == map[r][c]) {
                                map[idx - 1][c] = save * 2;
                                save = 0;
                                map[r][c] = 0;
                            }
                            // 다르면 저장 
                            else {
                            	save = map[r][c];
                                map[r][c] = 0;
                                map[idx][c] = save;
                                idx++;
                            }
                        }
                    }
                }
                break;
            // 하 
            case 1:
                for(int c = 0; c < N; c++) {
                    idx = N - 1;
                    save = 0;
                    for(int r = N-1 ; r>=0 ; r--) {
                        if(map[r][c] != 0) {
                            if(save == map[r][c]) {
                                map[idx + 1][c] = save * 2;
                                save = 0;
                                map[r][c] = 0;
                            }
                            else {
                            	save = map[r][c];
                                map[r][c] = 0;
                                map[idx][c] = save;
                                idx--;
                            }
                        }
                    }
                }
                break;
            // 좌 
            case 2:
                for(int r=0 ; r<N ; r++) {
                    idx = 0;
                    save = 0;
                    for(int c=0 ; c<N ; c++) {
                        if(map[r][c] != 0) {
                            if(save == map[r][c]) {
                                map[r][idx - 1] = save * 2;
                                save = 0;
                                map[r][c] = 0;
                            }
                            else {
                            	save = map[r][c];
                                map[r][c] = 0;
                                map[r][idx] = save;
                                idx++;
                            }
                        }
                    }
                }
                break;
            // 우 
            case 3:
                for(int r=0; r<N; r++) {
                    idx = N - 1;
                    save = 0;
                    for(int c=N-1 ; c>=0 ; c--) {
                        if(map[r][c] != 0) {
                            if(save == map[r][c]) {
                                map[r][idx + 1] = save * 2;
                                save = 0;
                                map[r][c] = 0;
                            }
                            else {
                            	save = map[r][c];
                                map[r][c] = 0;
                                map[r][idx] = save;
                                idx--;
                            }
                        }
                    }
                }
                break;
        }
    }
}
