import java.util.*;
import java.io.*;
 
public class Main{   
    static ArrayList<Long> list;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        list = new ArrayList<>();
        
        
        if(num<=10) {
        	System.out.println(num);
        }
        else if(num>=1023) {
        	System.out.println(-1);
        }
        else {
        	for(int i=0; i<10;i++) {    //0~부터 9까지 앞자리 개수 세기 
        		cal(i,1);				//해서 depth10보다 크거나,for문이 다돌면 
        	}
        	Collections.sort(list);		//크기대로 정렬후에 
        	System.out.println(list.get(num));	//원하는 num값 뽑아오
        }
    }
    private static void cal(long num, int depth) { 	//이쪽 Long을 넣어야 하는것을 인지하는게 오래걸렸다.
    	if(depth>10) {			//9876543210 10자리 
    		return;
    	}
    	list.add((long)num);			
    	
    	for(int i=0; i<num%10;i++) {	//앞자리보다 작은 수가 나오면 끝까지 검색 후 나오게 ,신기한거 [num%10  236 ms] | [ 10 220ms ]
    		if(num%10 >i) {			 
    			cal((num*10)+i, depth+1);
    			}
    	}
    	return;
    }
}





/* 브루트포스로 하는 방법인거 같은데, 이렇게 하니 시간이 너무 오래걸린다.
package chapter2;

import java.util.*;
import java.io.*;

public class TypeInference{
	static boolean status;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;				// num과 값이 같아진다면 멈추게 할 변수 

		
		if(num<=10) {
			System.out.println(num);
		}
		else {
			count = 10;
			for(int i=11; i<Integer.MAX_VALUE;i++) {
				if(cal(i)) {
					count++;
				}
				else {
					continue;
				}
				if(count==num) {
					if(status==true) {
						System.out.println(i);
						break;
					}
					else {
						System.out.println(-1);
						break;
					}
					
				}
				
			}
		}
	}
	static boolean cal(int i) {
		String str = Integer.toString(i);
		String[] arr = str.split("");
		for(int j=0;j<arr.length-1;j++) {
			if(Integer.parseInt(arr[j])>Integer.parseInt(arr[j+1])) {
				status = true;
			}
			else {
				status = false;
				break;
			}
		}
		return status;
	}
}
*/
