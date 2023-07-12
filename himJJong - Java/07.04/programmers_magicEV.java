public class programmers_magicEV {
    public static void main(String[] args) {
        int storey = 9999;
        String tmp = Integer.toString(storey);
        int[] arr = new int[tmp.length()];

        for(int i=0; i<tmp.length(); i++) {
            arr[i] = tmp.charAt(i) - '0';
        }

        int answer = 0;

        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] > 5) {
                answer += 10-arr[i];    // 값 구하기

                if(i==0) answer++;      // 제일 큰 숫자가 5보다 크다면 위에서 내리는게 편하므로
                else arr[i-1]++;        // 그게 아니라면 앞의 자릿수자 +1
            }
            else if(arr[i]==5 && i>0 && arr[i-1]>=5) {
                arr[i-1]++;             //
                answer += 5;            // 어차피 위든 아래든 5는 같으니 값 플러스
            }
            else {
                answer += arr[i];
            }
        }

        System.out.println(answer);
    }
}