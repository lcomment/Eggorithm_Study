import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_23294{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int curCache = 0;
        int curPage = 0;
        int aCount = 0;

        Deque<Integer> bDq = new LinkedList<>();
        Deque<Integer> fDq = new LinkedList<>();

        int[] cacheArr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            cacheArr[i] = Integer.parseInt(st.nextToken());
        }

        while(Q -- >0){
            String tmp = br.readLine();
            String[] order = tmp.split(" ");

            if(order[0].equals("A")){
                if(aCount == 0){
                    curPage = Integer.parseInt(order[1]);
                    curCache += cacheArr[curPage];
                    aCount++;
                    continue;
                }
                if(!fDq.isEmpty()){ // front dq가 비어있지 않다면 모두삭제
                    while(!fDq.isEmpty()){
                        curCache -= cacheArr[fDq.pollFirst()];
                    }
                }
                bDq.addLast(curPage);
                curPage = Integer.parseInt(order[1]);
                if(curCache + cacheArr[curPage] > C){
                    while(true){
                        if(bDq.isEmpty())   break;
                        int dump = bDq.pollFirst();
                        curCache -= cacheArr[dump];

                        if(curCache + cacheArr[curPage] <= C){
                            curCache += cacheArr[curPage];
                            break;
                        }
                    }
                }
                else{
                    curCache += cacheArr[curPage];
                }
            }
            else if(order[0].equals("B")){
                if(!bDq.isEmpty()) {
                    fDq.addFirst(curPage);
                    curPage = bDq.pollLast();
                }
            }
            else if(order[0].equals("F")){
                if(!fDq.isEmpty()){
                    bDq.addLast(curPage);
                    curPage = fDq.pollFirst();
                }
            }
            else if(order[0].equals("C")){
                Stack<Integer> s = new Stack<>();
                while(!bDq.isEmpty()) {
                    if (s.isEmpty()) {
                        s.add(bDq.pollLast());
                    } else {
                        if (s.peek().equals(bDq.peekLast())) {
                            curCache -= cacheArr[bDq.pollLast()];
                        } else s.add(bDq.pollLast());
                    }
                }
                while(!s.isEmpty()){
                    bDq.addLast(s.pop());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(curPage).append("\n");

        if(bDq.isEmpty()){
            sb.append("-1").append("\n");
        }
        else{
            while(!bDq.isEmpty()){
                sb.append(bDq.pollLast()).append(" ");
            }
            sb.append("\n");
        }

        if(fDq.isEmpty()){
            sb.append("-1");
        }
        else{
            while(!fDq.isEmpty()){
                sb.append(fDq.pollFirst()).append(" ");
            }
        }

        System.out.println(sb);
    }
}