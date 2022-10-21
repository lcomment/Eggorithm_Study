//1차 접근 - 0이 아닌 데이터는 면적 넓이로 , 0인 데이터는 x와 y배열을 따로 만들어주기. 
//문제 : 1) 넓이의 값으로 해당 좌표를 알 수 없다 2) 탐색하기에 범위가 너무 넓다. 
//2차 접근 - 별 위치를 중심으로 모서리 끝 4가지 방향 + 중간 지점으로 4방향 + 별을 중심으로 1가지 9가지로 탐색
//문제 : 별이 많이 존재하는 위치가 특정 부분에 몰릴 수 있다.
import java.io.*;
import java.util.*;

public class Main {
	static int line_x;
	static int line_y;
	static int tramper;		// 트램펄린  
	static int star;		// 별의 개수 
	static int answer;
	static String[] check_data;
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		xq = new LinkedList<>();
		yq = new LinkedList<>();
		
		line_x = Integer.parseInt(st.nextToken());
		line_y = Integer.parseInt(st.nextToken());
		tramper = Integer.parseInt(st.nextToken());
		star = Integer.parseInt(st.nextToken());
		check_data = new String[star];
			
		for(int i=0; i<star; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			check_data[i] = Integer.toString(a)+" "+Integer.toString(b);
					
			xq.add(a);
			yq.add(b);
		}
		
		answer = 0;
		int checkdata = star;
		while(checkdata-- >0) {
			int x = xq.remove();
			int y = yq.remove();
			
			answer=Math.max(answer,one(x,y));
			answer=Math.max(answer,two(x,y));
			answer=Math.max(answer,three(x,y));
			answer=Math.max(answer,four(x,y));
			answer=Math.max(answer,center((double)x,(double)y));
			answer=Math.max(answer,right((double)x,(double)y));
			answer=Math.max(answer,top((double)x,(double)y));
			answer=Math.max(answer,left((double)x,(double)y));
			answer=Math.max(answer,bottom((double)x,(double)y));
		}
		
		System.out.println(star-answer);
	}
	
	
	static int one(int x,int y) {
		int count = 0;
		int center_x = x;
		int center_y = y;
		
		int move_x = x+tramper;
		int move_y = y+tramper;
		
		if(move_x>line_x) move_x = line_x;
		if(move_y>line_y) move_y = line_y;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}		
		answer=count;
		return answer;
	}
	
	static int two(int x,int y) {
		int count = 0;
		int center_x = x-tramper;
		int center_y = y;
		
		int move_x = x;
		int move_y = y+tramper;
		
		if(center_x<0) center_x = 0;
		if(move_y>line_y) move_y = line_y;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}		
		answer = count;
		return answer;
	}
	
	static int three(int x,int y) {
		int count = 0;
		int center_x = x-tramper;
		int center_y = y-tramper;
		
		int move_x = x;
		int move_y = y;
		
		if(center_x<0) center_x = 0;
		if(center_y<0) center_y = 0;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}		
		answer = count;
		return answer;
	}
	
	static int four(int x,int y) {
		int count = 0;
		int center_x = x;
		int center_y = y-tramper;
		
		int move_x = x+tramper;
		int move_y = y;
		
		if(move_x>line_x) move_x = line_x;
		if(center_y<0) center_y = 0;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}		
		answer = count;
		return answer;
	}
	static int right(double x, double y) {
		int count=0;
		double center_x =0;
		double center_y =0;
		double move_x =0;
		double move_y =0;
		if(tramper%2==1) {
			center_x = x;
			center_y = y-(tramper/2+0.5);
			
			move_x = x+tramper;
			move_y = y+(tramper/2+0.5);
		}
		else {
			center_x = x;
			center_y = y-(tramper/2);
			
			move_x = x+tramper;
			move_y = y+(tramper/2);
		}
		
		if(center_y<0) center_y = 0;
		if(move_x>line_x) move_x = line_x;
		if(move_y>line_y) move_y = line_y;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}	
		
		answer = count;
		return answer;
	}
	static int top(double x, double y) {
		int count=0;
		double center_x =0;
		double center_y =0;
		double move_x =0;
		double move_y =0;
		if(tramper%2==1) {
			center_x = x-(tramper/2+0.5);
			center_y = y;
			
			move_x = x+(tramper/2+0.5);
			move_y = y+(tramper);
		}
		else {
			center_x = x-tramper/2;
			center_y = y;
			
			move_x = x+tramper/2;
			move_y = y+(tramper);
		}
		
		if(center_x<0) center_x = 0;
		if(move_x>line_x) move_x = line_x;
		if(move_y>line_y) move_y = line_y;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}	
		
		answer = count;
		return answer;
	}
	static int left(double x, double y) {
		int count=0;
		double center_x =0;
		double center_y =0;
		double move_x =0;
		double move_y =0;
		if(tramper%2==1) {
			center_x = x-tramper;
			center_y = y-tramper/2+0.5;
			
			move_x = x;
			move_y = y+tramper/2+0.5;
		}
		else {
			center_x = x-tramper;
			center_y = y-tramper/2;
			
			move_x = x;
			move_y = y+tramper/2;
		}
		
		if(center_x<0) center_x = 0;
		if(center_y<0) center_y = 0;
		if(move_y>line_y) move_y = line_y;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}	
		
		answer = count;
		return answer;
	}
	static int bottom(double x, double y) {
		int count=0;
		double center_x =0;
		double center_y =0;
		double move_x =0;
		double move_y =0;
		if(tramper%2==1) {
			center_x = x-tramper/2+0.5;
			center_y = y-tramper;
			
			move_x = x+tramper/2+0.5;
			move_y = y;
		}
		else {
			center_x = x-tramper/2;
			center_y = y-tramper;
			
			move_x = x+tramper/2;
			move_y = y;
		}
		
		if(center_x<0) center_x = 0;
		if(center_y<0) center_y = 0;
		if(move_x>line_x) move_x = line_x;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}	
		
		answer = count;
		return answer;
	}
	static int center(double x, double y) {
		int count=0;
		double center_x =0;
		double center_y =0;
		double move_x =0;
		double move_y =0;
		if(tramper%2==1) {
			center_x = x-tramper/2+0.5;
			center_y = y-tramper/2+0.5;
			
			move_x = x+tramper/2+0.5;
			move_y = y+tramper/2+0.5;
		}
		else {
			center_x = x-tramper/2;
			center_y = y-tramper/2;
			
			move_x = x+tramper/2;
			move_y = y+tramper/2;
		}
		
		if(center_x<0) center_x = 0;
		if(center_y<0) center_y = 0;
		if(move_x>line_x) move_x = line_x;
		if(move_y>line_y) move_y = line_y;
		
		for(int i=0; i<check_data.length; i++) {
			String[] data = check_data[i].split(" ");
			
			if(Integer.parseInt(data[0])>=center_x &&Integer.parseInt(data[0])<=move_x) {
				if(Integer.parseInt(data[1])>=center_y && Integer.parseInt(data[1])<=move_y) count++;
			}
		}	
		
		answer = count;
		return answer;
	}
}
