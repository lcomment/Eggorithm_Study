import java.io.*;
import java.util.*;

class SW_2 {
    static class Person {
        int a;
        int b;
        int c;
        int index;

        Person(int a, int b, int c, int index) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.index = index;
        }
    }
    static boolean[] visited;
    static Person[] goal;
    static int max;
    static List<Person> list;
    static int[] allSkillValue;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            allSkillValue = new int[N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int power = Integer.parseInt(st.nextToken());
                int intel = Integer.parseInt(st.nextToken());
                int speed = Integer.parseInt(st.nextToken());

                allSkillValue[j] = power + intel + speed;

                Person person = new Person(power, intel, speed, j);
                list.add(person);
            }
            max = Integer.MAX_VALUE;
            visited = new boolean[N];
            goal = new Person[3];

            if (N < 3) {
                bw.write("#" + test_case + " -1\n");
                continue;
            }

            btk(0, 0);
            bw.write("#" + test_case + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void btk(int index, int depth) {
        if (depth == 3) {
            max = Math.min(max, cal());
            return;
        }

        for (int i = index; i < list.size(); i++) {
            goal[depth] = list.get(i);
            btk(i + 1, depth + 1);
        }
    }

    private static int cal() {
        boolean[] visited = new boolean[list.size()];
        int sum = 0;
        int rest = 0;
        int whole = 0;

        for (int i = 0; i < 3; i++) {
            visited[goal[i].index] = true;
        }

        int f = Math.max(Math.max(Math.max(Math.max(goal[0].a + goal[1].b + goal[2].c, goal[0].a + goal[1].c + goal[2].b), goal[0].b + goal[1].a + goal[2].c), goal[0].b + goal[1].c + goal[2].a), Math.max(goal[0].c + goal[1].a + goal[2].b, goal[0].c + goal[1].b + goal[2].a));

        for (int i = 0; i < 3; i++) {
            sum += allSkillValue[goal[i].index];
        }
        sum -= f;

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                rest += Math.max(list.get(i).a, Math.max(list.get(i).b, list.get(i).c));
                whole += allSkillValue[i];
            }
        }
        rest = whole - rest;
        return sum + rest;
    }
}
