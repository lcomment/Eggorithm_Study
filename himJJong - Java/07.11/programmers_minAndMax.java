import java.util.Arrays;

public class programmers_minAndMax {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        String[] data = s.split(" ");

        int[] dataInt = new int[data.length];

        for(int i=0; i<dataInt.length; i++){
            dataInt[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(dataInt);

        String answer = "";

        answer += dataInt[0]+" ";
        answer += dataInt[dataInt.length-1];

        System.out.println(answer);
    }
}
