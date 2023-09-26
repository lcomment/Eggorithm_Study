import java.util.Deque;
import java.util.LinkedList;

public class Test{
    static String s = "aaaababab";
    static String[] word_dict = {"aaa","aaaa","ab","bab","aababa"};
    static int max = Integer.MIN_VALUE;
    static StringBuilder answer;
    public static void main(String[] args) {
        for(int i=0; i< word_dict.length; i++){
            if(word_dict[i].charAt(0) == s.charAt(0)) {
                answer = new StringBuilder();
                answer.append(word_dict[i]);
                backTracking(1);
            }
        }
        System.out.println(max);
    }

    private static void backTracking(int val) {
        if(answer.length() >= s.length()){
            if(s.equals(answer.toString())){
                max = Math.max(max, val);
            }
            return;
        }

        for(int i=0; i<word_dict.length; i++){
            if(word_dict[i].charAt(0) == answer.charAt(answer.length()-1)) {
                answer.append(word_dict[i].substring(1));
                backTracking(val + 1);
                answer.delete(answer.length()+1 - word_dict[i].length(), answer.length());
            }
        }
    }
}
