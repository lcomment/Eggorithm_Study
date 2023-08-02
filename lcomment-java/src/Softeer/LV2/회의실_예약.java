package Softeer.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 회의실_예약 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, List<Part>> reserveTable = new TreeMap<>();

    int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = NM[0];
    int M = NM[1];

    for (int i = 0; i < N; i++) {
      reserveTable.put(br.readLine(), new ArrayList<>());
    }
    for (int i = 0; i < M; i++) {
      String[] input = br.readLine().split(" ");

      reserveTable.get(input[0]).add(new Part(stoi(input[1]), stoi(input[2])));
    }

    StringBuilder sb = new StringBuilder();
    for (String key : reserveTable.keySet()) {
      sb.append("Room ").append(key).append(":\n");

      List<Part> list = reserveTable.get(key);

      if(list.isEmpty()) {
        sb.append("1 available:\n").append("09-18\n").append("-----\n");
        continue;
      }

      list.sort(Comparator.comparingInt(p -> p.start));

      List<String> enableReserve = new ArrayList<>();
      if (list.get(0).start != 9) {
        enableReserve.add("09-" + list.get(0).start);
      }

      for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i).end == list.get(i + 1).start) {
          continue;
        }
        enableReserve.add(list.get(i).end + "-" + list.get(i + 1).start);
      }

      if (list.get(list.size() - 1).end != 18) {
        enableReserve.add(list.get(list.size() - 1).end + "-18");
      }

      if(enableReserve.isEmpty()) {
        sb.append("Not available\n");
      } else {
        sb.append(enableReserve.size()).append(" available:\n");
        for(String s : enableReserve) {
          sb.append(s).append("\n");
        }
      }

      sb.append("-----\n");
    }

    System.out.println(sb.substring(0, sb.length()-7));
  }

  private static int stoi(String s) {
    return Integer.parseInt(s);
  }

  static class Part {

    int start, end;

    Part(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
