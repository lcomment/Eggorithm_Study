package Softeer.LV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 강의실_배정 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    List<Edu> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      list.add(
          new Edu(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()));
    }
    Collections.sort(list);

    int save = list.get(0).end;
    int count = 1;
    for(int i=1 ; i<N ; i++) {
      Edu edu = list.get(i);

      if(save <= edu.start) {
        count++;
        save = edu.end;
      }
    }

    System.out.println(count);
  }

  static class Edu implements Comparable<Edu> {

    int start, end;

    Edu(int[] input) {
      this.start = input[0];
      this.end = input[1];
    }

    @Override
    public int compareTo(Edu o) {
      int result = this.end - o.end;
      return result == 0 ? this.start - o.start : result;
    }
  }
}
