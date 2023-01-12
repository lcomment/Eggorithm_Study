import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	static int n;
	public static void main(String args[]) throws Exception {
	    int T;
	    int[][] firstLotation;
		int[][] secondLotation;
		int[][] thirdLotation;
		int[][] arr;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer sb;
	    
	    T = Integer.parseInt(br.readLine());
		/*
		여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			//2차원 배열 초기화
			for(int i = 0; i < n; i++) {
				sb = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(sb.nextToken());
				}
			}
			firstLotation = rotateArray(arr);
			secondLotation = rotateArray(firstLotation);
			thirdLotation = rotateArray(secondLotation);
			
			System.out.println("#"+test_case);
			for(int i = 0; i < n; i++) {
				printArrays(firstLotation, i);
				printArrays(secondLotation, i);
				printArrays(thirdLotation, i);
				System.out.println("");
			}
		}
	}
	
	public static int[][] rotateArray(int[][] arr) {
		int[][] newArr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				newArr[i][j] = arr[n-j-1][i];
			}
		}
		return newArr;
	}
	
	public static void printArrays(int[][] arr, int i) {
		for(int j = 0; j < n; j++) {
			System.out.print(arr[i][j]);
		}
		System.out.print(" ");
	}
}