public class pro_숫자표현 {
    public static void main(String[] args) {
        int answer = Integer.MIN_VALUE;
        int n = 15;
        int count = 0;
        int copy = n;
        while (true) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 2 == 1) {
                count++;
                n /= 2;
            }

            if (n == 0 || n == 1) break;
        }
        if(n==1) count++;
        while(copy++ <= 1000000){
            int s = copy;
            int sum = 0;
            while(true) {
                if (s % 2 == 0) {
                    s /= 2;
                } else if (n % 2 == 1) {
                    sum++;
                    s /= 2;
                }
                if (s == 0 || s == 1) break;
            }
            if(s==1)    sum++;
            if(count == sum){
                answer = copy;
                break;
            }
        }
        System.out.println(answer);
    }
}