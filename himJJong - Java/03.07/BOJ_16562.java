import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_16562 {
    static int[] friendship;
    static int[] friendMoney;
    static int[] totalData;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        friendMoney = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        friendship = new int[NM[0]];
        totalData = new int[NM[0]];
        Arrays.fill(totalData,Integer.MAX_VALUE);
        int resultMoney = 0;

        for(int i=0; i<NM[0]; i++){
            friendship[i] = i;
        }

        for(int i=0; i<NM[1]; i++){
            int[] link = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            merge(link[0]-1,link[1]-1);
        }

        for(int i=0; i<NM[0]; i++){
            int val = findParent(i);
            totalData[val] = Math.min(totalData[val],friendMoney[i]);
        }

        Set<Integer> notDuplicatedParents = Arrays.stream(friendship)
                                                  .boxed()
                                                  .collect(Collectors.toSet());

        for(int parent : notDuplicatedParents) {
            resultMoney += totalData[parent];
        }
        
        if(resultMoney > NM[2]) {
            System.out.println("Oh no");
            System.exit(0);
        }
        else System.out.println(resultMoney);
    }

    private static void merge(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a>b){
            friendship[a] = b;
        }
        else if(b>a){
            friendship[b] = a;
        }
    }

    private static int findParent(int a) {
        if(friendship[a] == a) return a;
        else return friendship[a] = findParent(friendship[a]);
    }
}