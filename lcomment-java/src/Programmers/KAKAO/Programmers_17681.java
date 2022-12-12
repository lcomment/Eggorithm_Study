package Programmers.KAKAO;

public class Programmers_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];

        for(int i=0 ; i<n ; i++){
            StringBuilder binaryNum = new StringBuilder(Integer.toBinaryString(arr1[i] | arr2[i]));

            binaryNum.insert(0, "0".repeat(n-binaryNum.length()));
            map[i] = binaryNum.toString().replaceAll("1", "#").replaceAll("0", " ");
        } // for_i

        return map;
    }
}