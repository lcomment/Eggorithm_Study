package Softeer.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀_메뉴 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    String secret = br.readLine();
    String buttons = br.readLine();

    System.out.println(buttons.contains(secret) ? "secret" : "normal");
  }
}
