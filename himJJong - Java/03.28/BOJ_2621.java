import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2621 {
    static int max;
    static boolean sort;
    static String[][] card;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        max = Integer.MIN_VALUE;
        card = new String[5][2];

        for(int i=0; i<5; i++){
            st=new StringTokenizer(br.readLine());
            card[i][0] = st.nextToken();
            card[i][1] = st.nextToken();
        }

        Arrays.sort(card, (o1, o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        sort = numberIsSort(card);

        check();
        System.out.println(max);
    }

    private static boolean numberIsSort(String[][] card) {
        int sum = 0;

        for(int i=card.length-1; i>0; i--){
            sum = Integer.parseInt(card[i][1]) -  Integer.parseInt(card[i-1][1]);
            if(sum == 1) continue;
            else return false;
        }
        return true;
    }

    private static void check() {
        oneMethod();
        twoMethod();
        threeMethod();
        fourMethod();
        fiveMethod();
        sixMethod();
        sevenMethod();
        nineMethod();
    }

    private static void nineMethod() {
        max = Math.max(max, 100 + Integer.parseInt( card[4][1]));
    }

    private static void sevenMethod() {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> data = new ArrayList<>();
        List<Integer> sameNumber = new ArrayList<>();
        int maxnum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < card.length; i++) {
            if (!map.containsKey(card[i][1])) {
                map.put(card[i][1], 0);
                sum++;
            }
            else {
                map.put(card[i][1], map.get(card[i][1])+1);
                maxnum = Math.max(maxnum,map.get(card[i][1]));
            }
            if(!data.contains(Integer.parseInt(card[i][1]))) data.add(Integer.parseInt(card[i][1]));

            if(map.get(card[i][1]) == 1) sameNumber.add(Integer.parseInt(card[i][1]));
        }
        Collections.sort(data);

        if( maxnum == 1 && sum==3){
            max = Math.max(max, (sameNumber.get(1)*10) + (sameNumber.get(0)+300));
        }
        else if(sum==4){
            max = Math.max(max, sameNumber.get(0) + 200);
        }
    }

    private static void sixMethod() {
        HashMap<String, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < card.length; i++) {
            if (!map.containsKey(card[i][1])) {
                map.put(card[i][1], 0);

            }
            else map.put(card[i][1],map.get(card[i][1])+1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                sum += Integer.parseInt(entry.getKey()) + 400;
                break;
            }
        }
        max = Math.max(sum,max);
    }

    private static void fiveMethod() {
        if(sort){
            max = Math.max(max, 500 + Integer.parseInt(card[4][1]));
        }
    }

    private static void fourMethod() {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<card.length;i++){
            if(!map.containsKey(card[i][0])){
                map.put(card[i][0],0);
            }
            else map.put(card[i][0],map.get(card[i][0])+1);
        }
        if(map.size()==1) max = Math.max(max, 600 + Integer.parseInt(card[4][1]));
    }

    private static void threeMethod() {
        HashMap<String, Integer> map = new HashMap<>();
        int check = 0;
        int sum = 0;

        for(int i=0; i<card.length;i++){
            if(!map.containsKey(card[i][1])){
                map.put(card[i][1],0);
            }
            else map.put(card[i][1],map.get(card[i][1])+1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()==2){
                sum += Integer.parseInt(entry.getKey()) * 10;
                check+=2;
            }
            else if(entry.getValue()==1){
                sum += 700 + Integer.parseInt(entry.getKey());
                check++;
            }
            else break;
        }
        if(check==3)    max = Math.max(max, sum);
    }

    private static void twoMethod() {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<card.length;i++){
            if(!map.containsKey(card[i][1])){
                map.put(card[i][1],0);
            }
            else map.put(card[i][1],map.get(card[i][1])+1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()==3) {
                max = Math.max(max, 800 + Integer.parseInt(entry.getKey()));
                break;
            }
        }
    }

    private static void oneMethod() {
        List<String> tmp = new ArrayList<>();
        int size = 1;
        tmp.add(card[0][0]);

        for(int i=1; i<card.length; i++){
            if(tmp.get(0).equals(card[i][0])) size++;
        }
        if(size == 5 && sort){
            max = 900 + Integer.parseInt(card[4][1]);
        }
    }
}
