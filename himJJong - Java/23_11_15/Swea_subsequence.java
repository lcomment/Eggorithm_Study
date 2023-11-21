import java.util.Scanner;

class Swea_subsequence {
    static int N, K, countK;
    static int[] arr;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();			// 원소 개수
            K = sc.nextInt();			// 부분집합의 합

            visited = new boolean[N];
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();	// 수열 입력받기
            }
            countK = 0;
            powerset(0, 0);

            System.out.println("#" + test_case + " " + countK);
        }
    }
    static void powerset(int at, int sum) {
        if(sum == K) {
            countK++;		// 부분집합의 합이 K와 같으면
            return;
        }
        else if(sum > K) {
            return;
        }
        for(int i=at; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                powerset(i, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}