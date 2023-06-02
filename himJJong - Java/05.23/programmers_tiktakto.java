import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class programmers_tiktakto {
    static String[][] board = {{"OO."}, {"..."}, {"..."}};
    static int circle = 0;
    static int error = 0;
    public static void main(String[] args)throws IOException {
        String[][] data = new String[3][3];

        for(int i=0; i<3; i++){
            String tmp = board[i][0];
            data[i] = tmp.split("");
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(data[i][j].equals("O"))   circle++;
                else if(data[i][j].equals("X")) error++;
            }
        }

        if(error > circle || Math.abs(error-circle) >=2) {      // 에러가 O 보다 많을때, 둘의 차이가 2 이상일때
            System.out.println(0);
        }
        if(error == 0 && error == circle) System.out.println(1);    // 둘다 0일 때 가능
        if(circle == 2 && (error == 1 || error ==2)) System.out.println(1); // circle 2이하이면서, error 1,2개이면 성공
        if(circle == 1 && (error == 1 || error ==0)) System.out.println(1); // circle 2이하이면서, error 1,2개이면 성공

        int flag = 0;

        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                if(data[i][j].equals(data[i][j+1]) && data[i][j].equals("O")) flag++;
            }
            if(flag==2 && circle > error) System.out.println(1);
            if(flag==2 && circle == error) System.out.println(0);
            flag=0;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                if(data[j][i].equals(data[j+1][i]) && data[j][i].equals("O")) flag++;
            }
            if(flag==2 && circle > error) System.out.println(1);
            if(flag==2 && circle == error) System.out.println(0);
            flag=0;
        }

        for(int i=0;i<2; i++){
            for(int j=0; j<2; j++) {
                if(data[i][j].equals(data[i+1][j+1]) && data[j][i].equals("O")) flag++;
            }
            if(flag==2 && circle > error) System.out.println(1);
            if(flag==2 && circle == error) System.out.println(0);
            flag=0;
        }

        for(int i=2;i>0; i--){
            for(int j=0; j<2; j++) {
                if(data[i][j].equals(data[i-1][j+1]) && data[j][i].equals("O")) flag++;
            }
            if(flag==2 && circle > error) System.out.println(1);
            if(flag==2 && circle == error) System.out.println(0);
            flag=0;
        }


        System.out.println(1);
    }
}

















