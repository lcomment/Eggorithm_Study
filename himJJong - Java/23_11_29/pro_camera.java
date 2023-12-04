import java.util.*;

class pro_camera {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<routes.length; i++){
            if(s.isEmpty()){
                s.add(routes[0][1]);
                answer++;
            }

            if(s.peek() < routes[i][0]){
                s.pop();
                s.add(routes[i][1]);
                answer++;
            }
        }

        return answer;
    }
}