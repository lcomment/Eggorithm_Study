public class BOJ_12891 {
    static String arr;
    static int[] typesCount = new int[200];
    static int[] currCount = new int[200];

    static int S, P, totalCnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        arr = br.readLine();

        st = new StringTokenizer(br.readLine());
        typesCount['A'] = Integer.parseInt(st.nextToken());
        typesCount['C'] = Integer.parseInt(st.nextToken());
        typesCount['G'] = Integer.parseInt(st.nextToken());
        typesCount['T'] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < P - 1; i++) {
            currCount[arr.charAt(i)]++;
        }
        getCase();
        System.out.println(totalCnt);
    }

    public static void getCase() {
        int start = 0, end;

        for(; start + P <= S; start++) {
            end = start + P - 1;
            currCount[arr.charAt(end)]++;
            if(isPossible()) totalCnt++;
            currCount[arr.charAt(start)]--;
        }
    }

    public static boolean isPossible() {
        if(currCount['A'] < typesCount['A']){
            return false;
        }
        if(currCount['C'] < typesCount['C']) {
            return false;
        }
        if(currCount['G'] < typesCount['G']){
            return false;
        }
        return currCount['T'] >= typesCount['T'];
    }
}