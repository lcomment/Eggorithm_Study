public class test1 {
    public static void main(String[] args) {
        System.out.println(findNumber(10));;
    }
    public static int findNumber(int n) {
        if (n % 5 == 0) {
            return n / 5;
        }

        else {
            int q = n / 5;
            for (int i = q; i >= 0; i--) {
                int remainder = n - (5 * i);
                if (remainder % 3 == 0) {
                    return i + (remainder / 3);
                }
            }
        }
        return -1;
    }
}

