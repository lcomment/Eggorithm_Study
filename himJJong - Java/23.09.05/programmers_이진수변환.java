class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int num = 0;
        int sum = 0;

        while(!s.equals("1")){
            System.out.println(s);
            num++;
            int zeroCount = 0;
            int size = 0;
            String[] tmp = s.split("");
            for(int i=0; i<s.length(); i++){
                if(tmp[i].equals("0")){
                    zeroCount++;
                    tmp[i] = "";
                }
                else{
                    size++;
                }
            }
            sum += zeroCount;
            s = Integer.toBinaryString(size);
        }
        answer[0] = num;
        answer[1] = sum;

        return answer;
    }
}