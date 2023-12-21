public class pro_연속부분수열 {
    public static void main(String[] args) {
        int[] sequence = {1,1,1,1,1,1,3};
        int k = 3;

        int[] answer = new int[2];
        answer[1] = sequence.length-1;
        answer[0] = 0;

        int left = 0;
        int right = 1;
        int sum = sequence[left];

        while(left < right){
            if(sum == k && (answer[1] - answer[0] > right - left-1)){
                answer[1] = right-1;
                answer[0] = left;

                sum -= sequence[left++];
                if(right == sequence.length){
                    right--;
                }
                sum += sequence[right++];
            }
            else if(sum > k){
                sum -= sequence[left++];
            }
            else if(right < sequence.length){
                sum += sequence[right++];
            }
            else break;
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
