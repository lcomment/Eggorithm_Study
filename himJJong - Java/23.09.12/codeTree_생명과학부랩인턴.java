import java.util.Scanner;

public class  codeTree_생명과학부랩인턴{
    static class Tuple {
        int first;
        int second;
        int third;
        public Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
        public boolean isHigher(Tuple t) {
            if(this.first != t.first)
                return this.first > t.first;
            return false;
        }
    }
    public static final Tuple BLANK = new Tuple(-1, -1, -1);
    public static final int MAX_NUM = 100;
    public static int n, m, k;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static Tuple[][] mold = new Tuple[MAX_NUM][MAX_NUM];
    public static Tuple[][] nextMold = new Tuple[MAX_NUM][MAX_NUM];
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                mold[i][j] = BLANK;

        for(int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int b = sc.nextInt();

            if(d <= 2)
                s %= (2 * n - 2);
            else
                s %= (2 * m - 2);

            mold[x - 1][y - 1] = new Tuple(b, s, d - 1);
        }
        for(int col = 0; col < m; col++)
            simulate(col);

        System.out.print(ans);
    }
    public static void simulate(int col) {
        collect(col);
        moveAll();
    }
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    public static void collect(int col) {
        for(int row = 0; row < n; row++)
            if(mold[row][col] != BLANK) {
                int moldSize = mold[row][col].first;
                ans += moldSize;
                mold[row][col] = BLANK;
                break;
            }
    }
    public static void moveAll() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                nextMold[i][j] = BLANK;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(mold[i][j] != BLANK)
                    move(i, j);

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                mold[i][j] = nextMold[i][j];
    }
    public static void move(int x, int y) {
        int moldSize = mold[x][y].first;
        int dist = mold[x][y].second;
        int moveDir = mold[x][y].third;

        Tuple next = getNextPos(x, y, dist, moveDir);
        int nextX = next.first;
        int nextY = next.second;
        int nextDir = next.third;

        Tuple newMold = new Tuple(moldSize, dist, nextDir); // x,y 방향만 체크해주면 되고 움직인 후
        if(newMold.isHigher(nextMold[nextX][nextY]))
            nextMold[nextX][nextY] = newMold;
    }
    public static Tuple getNextPos(int x, int y, int dist, int moveDir) {
        while(dist-- > 0) {
            int nextX = x + dx[moveDir];
            int nextY = y + dy[moveDir];
            if(inRange(nextX, nextY)) {
                x = nextX;
                y = nextY;
            }
            else {
                moveDir = (moveDir % 2 == 0) ? (moveDir + 1) : (moveDir - 1);
                x = x + dx[moveDir];
                y = y + dy[moveDir];
            }
        }
        return new Tuple(x, y, moveDir);
    }
}