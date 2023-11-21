import java.util.Scanner;
import java.io.FileInputStream;

class Swea_369
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        for(int i=1; i<=N; i++) {
            String tmp = String.valueOf(i);
            String[] data = tmp.split("");
            String answer = "";
            for(int j=0; j<data.length; j++){
                if(data[j].equals("3")){
                    answer += "-";
                }
                else if(data[j].equals("6")){
                    answer += "-";
                }
                else if(data[j].equals("9")){
                    answer += "-";
                }
            }

            if(answer.equals("")){
                System.out.print(i+" ");
            }
            else{
                System.out.print(answer+" ");
            }
            answer = "";
        }
    }
}