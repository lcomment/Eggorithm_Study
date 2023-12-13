import java.util.HashMap;

public class pro_롤케이크 {
    public static void main(String[] args) {
        int[] topping = {1,2,3,4,5};
        System.out.println(Solution.solution(topping));
    }

    static class Solution {
        static public int solution(int[] topping) {
            int count = 0;
            int answer = 0;
            HashMap<Integer, Integer> all = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();

            for(int i=0; i<topping.length; i++){
                all.put(topping[i],all.getOrDefault(topping[i],0)+1);
            }

            for(int i=0; i<topping.length; i++){
                left.put(topping[i],left.getOrDefault(topping[i],0)+1);
                if(all.get(topping[i])-1 == 0){
                    all.remove(topping[i]);
                }
                else{
                    all.put(topping[i], all.get(topping[i])-1);
                }

                if(all.size() == left.size()){
                    count++;
                }
            }

            if(count == 0){
                return 0;
            }
            return count;
        }
    }
}
