import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1700 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] tools = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            tools[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] use = new boolean[101];

        int answer = 0;
        int put = 0;

        for(int i=0; i<K; i++){
            if(!use[tools[i]]){
                if(put < N){
                    use[tools[i]] = true;
                    put++;
                }

                else{
                    List<Integer> list = new ArrayList<>();
                    for(int j=i; j<K; j++) {
                        if (use[tools[j]] && !list.contains(tools[j])) {
                            list.add(tools[j]);
                        }
                    }
                    if(list.size() != N){
                        for(int k=1; k<use.length; k++){
                            if(use[k] && !list.contains(k)){
                                use[k] = false;
                                use[tools[i]] = true;
                                break;
                            }
                        }
                    }
                    else{
                        int remove = list.get(list.size()-1);
                        use[remove] = false;
                        use[tools[i]] = true;
                    }
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}