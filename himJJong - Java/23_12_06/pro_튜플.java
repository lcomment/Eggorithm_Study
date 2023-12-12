import java.util.*;

public class pro_튜플 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("123"));
    }
    static class Solution {
        static class Node{
            String data;
            int length;

            Node(String data, int length){
                this.data = data;
                this.length = length;
            }
        }
        static public int[] solution(String s) {
            int[] answer;
            List<Node> list = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            String[] parts = s.substring(2, s.length() - 2).split("\\},\\{");

            for(int i=0; i<parts.length; i++){
                list.add(new Node(parts[i], parts[i].length()));
            }

            answer = new int[list.size()];

            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.length - o2.length;
                }
            });

            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                String[] result1 = list.get(i).data.split(",");
                for(int j=0; j<result1.length; j++){
                    if(!set.contains(Integer.parseInt(result1[j]))){
                        set.add(Integer.parseInt(result1[j]));
                        result.add(Integer.parseInt(result1[j]));
                    }
                }
            }
            for(int i=0; i<list.size(); i++){
                answer[i] = result.get(i);
            }
            return answer;
        }
    }
}



