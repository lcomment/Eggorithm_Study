import java.util.*;

class pro_diskController {
    public static void main(String[] args) {
        int[][] jobs = {{4, 7}, {1, 9}, {0, 3}, {2, 6},{4,6}};
        System.out.println(solution(jobs));
    }
    static public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;

        while(count < jobs.length){

            while(index < jobs.length && jobs[index][0] <= end){
                q.add(jobs[index++]);
            }

            if(q.isEmpty()){
                end = jobs[index][0];
            }
            else{
                int[] cur = q.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
        return total/jobs.length;
    }
}