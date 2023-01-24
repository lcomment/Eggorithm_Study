import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
class Solution{
    public static void main(String args[]) throws Exception{
         
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
             
            for(int i = 0; i < num1; i++) {
                list1.add(sc.nextInt());
            }
             
            for(int i = 0; i < num2; i++) {
                list2.add(sc.nextInt());
            }
             
            if(num1 <= num2) {
                 System.out.println("#" + test_case + " " + getMaxValue(list1, list2));
            }else if(num1 > num2) {
                 System.out.println("#" + test_case + " " + getMaxValue(list2, list1));
            } 
        }
    }
     
     
    public static int getMaxValue(List<Integer> list1, List<Integer> list2) {
        int maxNumber = 0;
        for (int i = 0; i + list1.size() <= list2.size(); i++ ) {
            int temp = 0;
            for(int j = 0; j < list1.size(); j++ ) {
                temp += (list1.get(j) * list2.get(i + j));
            }
            maxNumber = Math.max(maxNumber, temp);
        }
        return maxNumber;
    }
}