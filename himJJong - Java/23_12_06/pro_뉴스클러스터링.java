import java.util.*;

class pro_뉴스클러스터링 {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1, str2));
    }
    static List<String> sum1 = new ArrayList<>();
    static List<String> sum2 = new ArrayList<>();
    static List<String> sum3 = new ArrayList<>();
    static List<String> dup = new ArrayList<>();
    static public int solution(String str1, String str2) {
        int answer = 0;

        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();


        String[] s1arr = s1.split("");
        String[] s2arr = s2.split("");

        for(int i=0;i<s1arr.length-1; i++){
            if(check(s1arr[i], s1arr[i+1])){
                String collect = s1arr[i] + s1arr[i+1];
                sum1.add(collect);
            }
        }

        for(int i=0;i<s2arr.length-1; i++){
            if(check(s2arr[i], s2arr[i+1])){
                String collect = s2arr[i] + s2arr[i+1];
                sum2.add(collect);
            }
        }

        for(String s: sum1){
            if(sum2.remove(s)){
                dup.add(s);
            }
            sum3.add(s);
        }

        for(String s : sum2){
            sum3.add(s);
        }

        if(sum3.isEmpty() && dup.isEmpty()){
            return 65536;
        }

        return (int) (((double) dup.size() / sum3.size()) * 65536);
    }
    public static boolean check(String arr, String arr2){
        if((97<=arr.charAt(0) && arr.charAt(0)<=122)  && (97<=arr2.charAt(0) && arr2.charAt(0)<=122)){
            return true;
        }
        return false;
    }
}