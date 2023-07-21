public class programmers_collect_dictionary {
    static int count = 0;
    static String[] answer;
    static String[] tmp;
    public static void main(String[] args){
        String word = "A";

        tmp = new String[5];

        tmp[0] = "A";
        tmp[1] = "E";
        tmp[2] = "I";
        tmp[3] = "O";
        tmp[4] = "U";

        answer = new String[5];

        backTracking(word,0);
    }

    private static void backTracking(String goal, int plus) {
        if(plus == 5)   return;

        for(int i=0; i<5; i++){
            count++;
            answer[plus] = tmp[i];
            if(plus == goal.length()-1 && check(goal)) {
                System.out.println(count);
                System.exit(0);
            }
            backTracking(goal, plus+1);
            answer[plus] = "";
        }
    }

    private static boolean check(String goal) {
        String tmp = "";

        for(int i=0; i<answer.length; i++){
            if(answer[i] == null) continue;
            tmp += answer[i];
        }
        if(tmp.equals(goal))    return true;
        return false;
    }
}
