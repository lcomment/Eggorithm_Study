import java.util.*;

public class pro_kakao {
    static boolean[] visited;
    static String[] answer;
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        visited = new boolean[user_id.length];
        answer = new String[banned_id.length];

        backTracking(0,"",user_id, banned_id);
        System.out.println(hs.size());
    }

    static void backTracking(int count,String res, String[] user_id, String[] banned_id){
        if(count == banned_id.length){
            String[] arr = res.split(" ");
            Arrays.sort(arr);

            String str = "";
            for (String s : arr) {
                str += s;
            }
            hs.add(str);
            return;
        }

        for(int i=0; i<user_id.length; i++){
            if(!visited[i] && check(user_id[i], banned_id[count])){
                visited[i] = true;
                backTracking(count+1,res+" "+user_id[i], user_id, banned_id);
                visited[i] = false;
            }
        }
    }
    static boolean check(String user_id, String banned_id){
        if(user_id.length() != banned_id.length())  return false;
        for(int i=0; i<user_id.length(); i++){
            if(user_id.charAt(i) == banned_id.charAt(i) || banned_id.charAt(i) == '*'){
                continue;
            }
            else return false;
        }
        return true;
    }
}










