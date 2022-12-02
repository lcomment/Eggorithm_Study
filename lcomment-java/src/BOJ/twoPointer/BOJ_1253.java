package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1253 {
		static int N, result = 0;
		static int[] seq;

	    public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        N = Integer.parseInt(br.readLine());
			seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

	        // Two Pointer 사용을 위해 정렬
			Arrays.sort(seq);

	        for(int i = 0 ; i < N ; i++){
	            int start = 0;
	            int end = N-1;  // 음수도 있기 때문에 N-1로 지정

	            while(true){
	                // i에 대해 좋다인지 판별중이기에 pointer가 i의 위치와 같으면 안됨
	                if(start == i) start++;
	                else if(end == i) end--;

	                // start 포인터는 end 포인터보다 항상 작아야 함
	                if(start >= end) break;
					
					int sum = seq[start] + seq[end];

	                if(sum > seq[i]) end--;  // sum의 값을 낮추기 위해 end를 앞으로 이동
	                else if(sum < seq[i]) start++;  // sum의 값을 높이기 위해 end를 앞으로 이동
	                else{   // 좋다인 경우
	                    result++;
	                    break;
	                }
	            }
	        }
	        System.out.println(result);
	    }

	}
