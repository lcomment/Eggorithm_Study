import java.util.Scanner;

public class BOJ_1074 {
    static int N,r,c,ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        function(0,0, (int) Math.pow(2,N));
    }

    private static void function(int x, int y, int size) {
        if(size==1){
            System.out.println(ans);
            return;
        }
        int newSize = size/2;

        if(r < x + newSize && c < y + newSize){ //1
            function(x,y,newSize);
        }
        else if(r < x + newSize && c >= y + newSize){   //2
            ans += (size*size) / 4;
            function(x,y+newSize, newSize);
        }
        else if(x+newSize <= r && c < y+newSize){   //3
            ans += ((size * size) / 4) * 2;
            function(x+newSize, y, newSize);
        }
        else if(x+newSize <= r && y+newSize <= c){  //4사분면
            ans += ((size*size) / 4) * 3;
            function(x+newSize , y+newSize, newSize);
        }
    }
}
