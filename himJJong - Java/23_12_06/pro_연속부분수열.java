import java.util.*;

class pro_연속부분수열 {
    HashSet<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int index = 1;

        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++){
                set.add(btk(i, 0, elements,0,j));
            }
        }
        return set.size();
    }

    public static int btk(int N, int sum, int[] elements, int cur,int index){
        if(N == cur){
            return sum;
        }
        if(index == elements.length){
            index = 0;
        }
        return btk(N, sum + elements[index], elements, cur+1, index+1);
    }
}