//1차 접근 - 0이 아닌 데이터는 면적 넓이로 , 0인 데이터는 x와 y배열을 따로 만들어주기. 
//문제 : 1) 넓이의 값으로 해당 좌표를 알 수 없다 2) 탐색하기에 범위가 너무 넓다. 

import java.io.*;
import java.util.*;

public class Main {
	static int line_x;
	static int line_y;
	static int square;
	static int star;
	static int[] nonzero_data;			//0이 아닌 Data 넓이 값
	static int nonzero_count = 0;
	static int[] zero_xdata;				//0인 x축 데이터 저장
	static int[] zero_ydata;				//0인 x축 데이터 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		line_x = Integer.parseInt(st.nextToken());
		line_y = Integer.parseInt(st.nextToken());
		square = Integer.parseInt(st.nextToken());
		star = Integer.parseInt(st.nextToken());
		
		zero_xdata = new int[line_x+1];
		zero_ydata = new int[line_y+1];
		nonzero_data = new int[(line_x*line_y)-(line_x+line_y-1)];
		int allzero = 0;
		
		for(int i=0; i<star; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a*b!=0) {
				nonzero_data[nonzero_count] = a*b;	//넓이 구해서 안에 포함되는지 - 정렬해도 될듯 
				nonzero_count++;
			}
			else if(a==0 && b==0) {				//특이 케이스 추출
				allzero++;
				continue;
			}
			else if(a==0) zero_ydata[b]=1;		//x축인 a값이 0일때 y축의 값인 b쪽 1로  
			else if(b==0) zero_xdata[a]=1;		//y축인 b값이 0일때 x축의 값인 a쪽 1
		}
	}
}

