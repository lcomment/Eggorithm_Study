import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class programmers_hotel {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o){
            if(o.start == this.start)   return o.end - this.end;
            return o.start - this.start;
        }
    }
    static Stack<Node> stack = new Stack<>();
    static List<Stack<Node>> list = new ArrayList<>();
    static String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
    public static void main(String[] args) {
        for(int i=0; i<book_time.length; i++){
            String a = book_time[i][0].substring(0,2);
            String b = book_time[i][0].substring(3);
            String front = a+b;

            String c = book_time[i][1].substring(0,2);
            String d = book_time[i][1].substring(3);
            String end = c+d;

            stack.add(new Node(Integer.parseInt(front),Integer.parseInt(end)));
        }

        Collections.sort(stack);
        list.add(new Stack<>());
        list.get(0).add(stack.pop());

        while (!stack.isEmpty()){

            Node tmp = stack.pop();
            for(int j=0; j<list.size(); j++) {
                int end = list.get(j).peek().end + 10;
                if(end % 100>= 60){
                    end += 100+(end%100)&60;
                }
                if (tmp.start >= end) {
                    list.get(j).add(tmp);
                    j=-1;
                    if(!stack.isEmpty())    tmp = stack.pop();
                    else break;
                }
                else if(j == list.size()-1) {
                    list.add(new Stack<>());
                    list.get(j + 1).add(tmp);
                    break;
                }
            }

        }
        System.out.println(list.size());
    }
}