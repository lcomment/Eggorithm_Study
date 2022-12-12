package Programmers.고득점킷.Greedy;

public class Programmers_42883 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int length = number.length() - k;

        int idx = 1;
        while(k>0 && idx != sb.length()) {
            if(sb.charAt(idx-1) < sb.charAt(idx)) {
                if(idx == 1)
                    sb.deleteCharAt(0);
                else {
                    sb.deleteCharAt(idx-1);
                    idx--;
                }
                k--;
            }
            else
                idx++;
        }
        if(sb.length() > length) {
            return sb.substring(0, length);
        }
        return sb.toString();
    }
}
