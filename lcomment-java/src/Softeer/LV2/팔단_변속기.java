package Softeer.LV2;

import java.io.*;

public class 팔단_변속기 {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String seq = br.readLine();

    if (seq.equals("1 2 3 4 5 6 7 8")) {
      System.out.println("ascending");
    } else if (seq.equals("8 7 6 5 4 3 2 1")) {
      System.out.println("descending");
    } else {
      System.out.println("mixed");
    }
  }
}
