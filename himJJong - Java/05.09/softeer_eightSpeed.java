import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class softeer_eightSpeed {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int upCount = 0;
        int downCount = 0;
        for(int i=0; i<8; i++){
            if(Integer.parseInt(tmp[i]) == i+1){
                upCount++;
            }
            if(Integer.parseInt(tmp[i]) == 8-(i)){
                downCount++;
            }
        }

        if(upCount == 8){
            System.out.println("ascending");
        }
        else if(downCount == 8){
            System.out.println("descending");
        }
        else System.out.println("mixed");
    }
}
