class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int leftH = heights[left];
            int rightH = heights[right];
            int height = Math.min(leftH, rightH);
            int length = right - left;
            int volume = height * length;
            if(volume > max){
                max = volume;
            }
            if(leftH > rightH){
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
