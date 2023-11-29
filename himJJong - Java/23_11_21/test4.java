class test4 {
    public static void main(String[] args) {
        int[] heights = {0,2,0,1,3,1,2,0,1,0,2,0};
        System.out.println(maxRainwater(heights));
    }
    public static int maxRainwater(int[] heights) {
        if (heights == null || heights.length <= 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int maxWater = 0;

        while(left < right){
            if(heights[left] < heights[right]){
                if(heights[left] >= leftMax){
                    leftMax = heights[left];
                }
                else{
                    maxWater += leftMax - heights[left];
                }
                left++;
            }
            else{
                if(heights[right] >= rightMax){
                    rightMax = heights[right];
                }
                else{
                    maxWater = rightMax - heights[right];
                }
                right--;
            }
        }

        return maxWater;
    }
}