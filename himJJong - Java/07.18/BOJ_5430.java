import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5430 {
    static ArrayDeque<Integer> deque;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while(T -- >0){
            String p = br.readLine();
            int number = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            deque = new ArrayDeque<Integer>();
            
            for(int i=0; i<number; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            Ac(p);   
        }

        System.out.println(sb);
    }

    private static void Ac(String p) {
        boolean direction = true;

        for(char function : p.toCharArray()){
            if(function == 'R'){
                direction = !direction;
                continue;
            }
            
            if(direction){
                if(deque.pollFirst() == null){
                    sb.append("error\n");
                    return;
                }
            }
            else{
                if(deque.pollLast() == null){
                    sb.append("error\n");
                    return;
                }
            }
        }
        makePrintString(direction);
    }

    private static void makePrintString(boolean direction) {
        sb.append("[");

        if(deque.size() >0){
            if(direction){
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else{
                sb.append(deque.pollLast());
                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append("\n");
    }
}