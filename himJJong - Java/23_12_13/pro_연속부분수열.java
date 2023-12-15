public class pro_연속부분수열 {
    public static void main(String[] args) {
        int[] sequence = {1,1,1,2,3,4,5};
        int k = 5;

        int[] answer = new int[2];
        answer[1] = sequence.length-1;
        answer[0] = 0;

        int left = 0;
        int right = 1;
        int sum = sequence[left];

        while(left < right){
            if(sum == k && (answer[1] - answer[0] > right - left-1)){
                answer[1] = right;
                answer[0] = left;

                sum -= sequence[left++];
            }
            else if(sum > k){
                sum -= sequence[left++];
            }
            else if(right < sequence.length){
                sum += sequence[right++];
            }
            else break;
        }
    }
}
