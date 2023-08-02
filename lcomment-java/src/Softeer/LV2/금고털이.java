package Softeer.LV2;

import java.util.*;
import java.io.*;
public class 금고털이 {

  static int weight, N, total = 0;
  static PriorityQueue<Jewelry> pq = new PriorityQueue<>((j1, j2) -> j2.price - j1.price);

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = sToIntArray(br.readLine());
    weight = input[0];
    N = input[1];

    for (int i = 0; i < N; i++) {
      input = sToIntArray(br.readLine());

      pq.offer(new Jewelry(input[0], input[1]));
    }

    while (!pq.isEmpty() && weight > 0) {
      Jewelry j = pq.poll();

      total += (j.weight >= weight ? weight : j.weight) * j.price;
      weight -= j.weight;
    }

    System.out.println(total);
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }
}

class Jewelry {

  int weight, price;

  Jewelry(int weight, int price) {
    this.weight = weight;
    this.price = price;
  }
}