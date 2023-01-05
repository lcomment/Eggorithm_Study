import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_20920 {
    static int N;
    static int M;
    static Map<String, Integer> map;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        map = new HashMap<>();

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0];
        M = NM[1];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (tmp.length() < M) continue;
            if (!map.containsKey(tmp)) map.put(tmp, 1);
            else map.put(tmp, map.get(tmp) + 1);
        }
        List<String> words = new ArrayList<>(map.keySet());
        //map.keySet().stream().toList();
        words.sort((o1, o2) -> {
            int c1=map.get(o1);
            int c2=map.get(o2);

            if(c1==c2){
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
                }
                return o2.length()-o1.length(); // 해당 단어의 길이가 길수록 앞에
            }
            return c2-c1; // 자주 나오는 단어일수록 앞에
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String word : words) {
            bw.append(word).append("\n");
        }

        bw.flush();
    }
}
/*
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] keyCount;
    static String[] keyString;
    static HashMap<String, Integer> map;
    static List<String> list;
    static String[] saveStringLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        list = new ArrayList<>();
        map = new HashMap<>();

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0];
        M = NM[1];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (tmp.length() < M) continue;
            if (!map.containsKey(tmp)) map.put(tmp, 1);
            else map.put(tmp, map.get(tmp) + 1);
        }
        mapToArray();

        for(int i=0; i<map.size()-1;i++){
            if(list.size() == map.size()) break;
            if(keyCount[i]>keyCount[i+1] && !list.contains(keyString[i])) {
                list.add(keyString[i]);           //나온 횟수
            }

            else if(keyCount[i] == keyCount[i+1]){
                checkStringLength(i);
            }
        }
        if(!list.contains(keyString[keyString.length-1])){
            list.add(keyString[keyString.length-1]);
        }
        for (String s : list) {
            bw.append(s).append("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void checkSameString(int start, int last) {
        String[] tmp = new String[last-start+1];
        int index = 0;
        for(int i=start; i<=last; i++){
            tmp[index] = keyString[i];
            index++;
        }
        Arrays.sort(tmp, (s1, s2) -> s2.length() - s1.length());

        for(int i=0; i<tmp.length-1; i++){
            if(tmp[i].length() != tmp[i+1].length()){
                list.add(tmp[i]);
            }
            else {
                checkStringLength(i);
            }
        }
    }

    private static void checkAlpha(int starta, int lastb) {
        String[] checksaveStringLength = new String[lastb-starta+1];
        int index = 0;
        for(int i=starta; i<=lastb; i++){
            checksaveStringLength[index] = saveStringLength[i];
            index++;
        }
        Arrays.sort(checksaveStringLength);
        Collections.addAll(list, checksaveStringLength);
    }

    private static void checkStringLength(int index) {
        int count = 0;
        saveStringLength = new String[keyString.length-index];
        int tmp = 0;
        for(int i=index; i< keyString.length; i++){
            saveStringLength[tmp] = keyString[i];
            tmp++;
        }
        Arrays.sort(saveStringLength, (s1, s2) -> s2.length() - s1.length());

        for(int i=0; i< saveStringLength.length-1 ;i++){
            if(saveStringLength[i].length() > saveStringLength[i+1].length() && !list.contains(saveStringLength[i])) list.add(saveStringLength[i]);
            if(saveStringLength[i].length() == saveStringLength[i+1].length()) {
                checkAlpha(i,i+1);;
            }
        }
    }

    private static void mapToArray() {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        keyCount = new int[map.size()];
        keyString = new String[map.size()];
        int index = 0;

        for (Map.Entry<String, Integer> entry : entryList) {
            keyCount[index] = entry.getValue();
            keyString[index] = entry.getKey();
            index++;
        }
    }
}
 */
