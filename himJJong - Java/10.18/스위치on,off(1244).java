import java.io.*;
import java.util.*;

public class Main {
	static int count;
	static int[] data;
	static int people;
	static int[][] sex;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		count = Integer.parseInt(st.nextToken());
		data = new int[count+1];
		int[] answer = new int[count+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=count ; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		people = Integer.parseInt(br.readLine());
		sex = new int[people+1][3];
		
		for(int i=1; i<=people; i++) {
			st = new StringTokenizer(br.readLine());
			int who = Integer.parseInt(st.nextToken());
			sex[i][who] = Integer.parseInt(st.nextToken());
		}
		
		if(count==1) {
			while(people-- >0) {
				data[1] = change(data[1]);
				answer[1] = data[1];
			}
		}
		
		else if(count==2) {
			for(int i=1; i<=people; i++) {
				int index = 0;
				for(int j=1; j<3; j++) {
					if(sex[i][j]==0) continue;
					else {
						index = j;		//남녀 구분 
					}
				}
				if(index==1) {			//남자일때  
					if(sex[i][index]==1) {
						data[sex[i][index]] = change(data[sex[i][index]]);
						data[sex[i][index]+1] = change(data[sex[i][index]+1]);
					}
					else {
						data[sex[i][index]] = change(data[sex[i][index]]);
					}
				}
				else if(index==2) {		//여자일때 
					data[sex[i][index]] = change(data[sex[i][index]]);
				}
			}
		}
		
		else {
			for(int i=1; i<=people; i++) {
				int index = 0;
				for(int j=1; j<3; j++) {
					if(sex[i][j]==0) continue;
					else {
						index = j;		//남녀 구분 
					}
				}
				if(index==1) {
					int[] multi = isman(sex[i][index]).clone();	//배수값 배열 리턴
					int num =0;
					for(int j=0;j<multi.length-1;j++) {
						if(multi[num]!=0 && multi[num]-1==j) {
							data[j+1] = change(data[j+1]);
							num++;
							
						}
					}
				}
				//sex[i][index] -> data의 위치 
				else if(index==2) {
					int pos = sex[i][index];
					int val =0;
				
					for(int j=1; j<=count/2 ;j++) {
						int front=0, back =0;
						 
						if(pos-j>=1 && pos+j<=data.length-1) {
							front = data[pos-j];
							back = data[pos+j];
							if(front==back) {
								val++;
							}
							else break;
						}
						else break;
					}
					if(val==0) {
						data[pos] = change(data[pos]);
					}
					else {
						for(int j=1; j<=val; j++) {
							data[pos+j]=change(data[pos+j]);
							data[pos-j] = change(data[pos-j]);
						}
						data[pos] = change(data[pos]);
					}
				}
			}
			
		
		}
		
		if(count==1) {
			System.out.println(answer[1]);
		}
		else if(3<=count && count<=20) {
			for(int i=1; i<=data.length-2;i++) {
				System.out.print(data[i]+" ");
			}
			System.out.print(data[data.length-1]);
		}
		else if(count>20){
			int num =0;
			for(int i=1; i<=data.length-1; i++) {
				if(num==20) {
					System.out.print("\n");
					num=0;
				}
				System.out.print(data[i]+" ");
				num++;
				
			}
		}	
	}
	static int[] isman(int val) {
		int save = 0;
		int[] mul = new int[data.length];
		for(int i=0; i<data.length; i++) {
			if(save+val<=data.length) {
				save += val;
				mul[i]=save;
				count++;
			}
			else break;
		}
		
		return mul;
	}
	
	static int change(int num) {
		if(num==0)	num=1;
		else if(num==1)num = 0;
		return num;
	}
}
