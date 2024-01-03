import java.util.Scanner;

public class BOJ_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] visited = new boolean[1003002];
        visited[0] = true;
        visited[1] = true;
        int N = sc.nextInt();

        for(int i=2; i<1100; i++){
            if(!visited[i]){
                for(int j=i*2; j<1003002; j+=i){
                    visited[j] = true;
                }
            }
        }

        StringBuilder sb;

        for(int i=N; i<1003002; i++){
            if(!visited[i]){
                sb = new StringBuilder();
                sb.append(i);

                if(String.valueOf(i).equals(String.valueOf(sb.reverse()))){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
