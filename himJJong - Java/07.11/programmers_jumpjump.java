public class programmers_jumpjump {
    public static void main(String[] args) {
        int n = 5;

        long result = 0;
        if(n == 1) System.out.println(1);
        if(n == 2) System.out.println(2);

        long[] answer = new long[n+1];
        answer[1] = 1;
        answer[2] = 2;
        for(int i=3; i<=n; i++){
            answer[i] = (answer[i-1] + answer[i-2]) % 1234567;
        }

        System.out.println(answer[n]);
    }
}
