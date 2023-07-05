package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Programmers_176962 {

    public static void main(String[] args) {
        String[][] p = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        System.out.println(Arrays.toString(Arrays.stream(solution(p)).toArray()));
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        // 해야할 과제들을 시작시간 순으로 저장
        PriorityQueue<Task> pq = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start));

        for (int i = 0; i < plans.length; i++) {
            pq.add(new Task(plans[i]));
        }

        // 잠시 멈춘 과제를 저장
        Stack<Task> remainingTasks = new Stack<>();

        while (!pq.isEmpty()) {
            Task current = pq.poll();

            String curName = current.title;
            int curStart = current.start;
            int curPlaytime = current.playtime;

            int currentTime = curStart;

            if (!pq.isEmpty()) {
                Task nextTask = pq.peek();

                // 과제를 끝냈는데 시간이 남음
                if (finishCondition(currentTime, curPlaytime, nextTask.start)) {
                    answer.add(curName);
                    currentTime += curPlaytime;

                    while (!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();

                        if (currentTime + rem.playtime <= nextTask.start) {
                            currentTime += rem.playtime;
                            answer.add(rem.title);
                        } else {
                            remainingTasks.push(new Task(rem.title,
                                                         rem.playtime - (nextTask.start - currentTime)));
                            break;
                        }
                    }
                }
                // 과제를 끝냈고 새 과제 시작
                else if (curStart + curPlaytime == nextTask.start) {
                    answer.add(curName);
                }
                // 과제를 못 끝냄
                else {
                    int t = (nextTask.start - currentTime);
                    remainingTasks.push(new Task(curName, curPlaytime - t));
                }

            }

            else {
                // 하다 만 과제 체크
                if (remainingTasks.isEmpty()) {
                    currentTime += curPlaytime;
                    answer.add(curName);
                }
                // 남아있는 과제는 있는 경우
                else {
                    answer.add(curName); // 새로운 과제부터 먼저 해결

                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while (!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();
                        answer.add(rem.title);
                    }
                }
            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    static boolean finishCondition(int currentTime, int playTime, int nextTime) {
        return currentTime + playTime < nextTime;
    }
}

class Task {
    String title;
    int start;
    int playtime;

    public Task(String[] plan) {
        this.title = plan[0];
        String[] time = plan[1].split(":");
        this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        this.playtime = Integer.parseInt(plan[2]);
    }

    public Task(String title, int playtime) {
        this.title = title;
        this.playtime = playtime;
    }
}