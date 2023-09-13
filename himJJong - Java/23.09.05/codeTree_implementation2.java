import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class codeTree_implementation2 {
    public static final int MAX_N = 15;

    public static int n;
    public static Pair[] segments = new Pair[MAX_N];

    public static int ans;
    public static ArrayList<Pair> selectedSegs = new ArrayList<>();

    public static boolean overlapped(Pair seg1, Pair seg2) {
        int ax1 = seg1.x;
        int ax2 = seg1.y;

        int bx1 = seg2.x;
        int bx2 = seg2.y;

        // 두 선분이 겹치는지 여부는
        // 한 점이 다른 선분에 포함되는 경우로 판단 가능합니다. 
        return (ax1 <= bx1 && bx1 <= ax2) || (ax1 <= bx2 && bx2 <= ax2) ||
                (bx1 <= ax1 && ax1 <= bx2) || (bx1 <= ax2 && ax2 <= bx2);
    }

    public static boolean possible() {
        // 단 한쌍이라도 선분끼리 겹치면 안됩니다.
        for(int i = 0; i < (int)selectedSegs.size(); i++)
            for(int j = i + 1; j < (int)selectedSegs.size(); j++)
                if(overlapped(selectedSegs.get(i), selectedSegs.get(j)))
                    return false;

        return true;
    }

    public static void findMaxSegments(int cnt) {
        if(cnt == n) {
            if(possible())
                ans = Math.max(ans, (int) selectedSegs.size());
            return;
        }

        selectedSegs.add(segments[cnt]);
        findMaxSegments(cnt + 1);
        selectedSegs.remove(selectedSegs.size() - 1);

        findMaxSegments(cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            segments[i] = new Pair(0, 0);

        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Pair(x1, x2);
        }

        findMaxSegments(0);

        System.out.print(ans);
    }
}