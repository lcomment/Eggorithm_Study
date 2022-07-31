package greedy;

// BOJ 1049번 기타줄 

import java.util.Scanner;

public class BOJ_1049 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      
      int set_min = 1001;
      int each_min = 1001;
      int set = -1;
      int each = -1;
      
      int answer = 0;
      
      for(int i = 0; i < M; i++) {
         set = sc.nextInt();
         each = sc.nextInt();
         if(set_min > set) set_min = set;
         if(each_min > each) each_min = each;
      }
      
      int min = set_min < 6 * each_min ? set_min : 6 * each_min;
      
      answer += (N/6) * min;
      
      answer += (set_min < N%6 * each_min) ? set_min : N%6 * each_min;
      
      System.out.println(answer);
      
   }
}