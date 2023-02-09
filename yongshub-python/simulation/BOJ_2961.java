import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
    static int[] sourTaste;
    static int[] bitterTaste;
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        initialize();
        bitMasking();
        System.out.println(answer);
    }

    public static void initialize() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        sourTaste = new int[N];
        bitterTaste = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sourTaste[i] = Integer.parseInt(st.nextToken());
            bitterTaste[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void bitMasking() {
        int number = (int)Math.pow(2, N);
        int num, totalSour, totalBitter;

        for(int i = 1; i < number; i++) {
            num = 1;
            totalSour = 1;
            totalBitter = 0;
            for(int j = 0; j < N; j++) {
                if((num & i) > 0) {
                    totalSour = totalSour * sourTaste[j];
                    totalBitter = totalBitter + bitterTaste[j];
                }
                num = num << 1;
            }
            answer = Math.min(answer, Math.abs(totalSour - totalBitter));
        }
    }
}
