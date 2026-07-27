class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int length = heights.length - 1;
        int left = 0;
        int right = heights.length - 1;

        while(left < right){
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            
            int minHeight = Math.min(leftHeight, rightHeight);

            int area = minHeight * (right - left);

            if(area > max){
                max = area;
            }

            if(minHeight == rightHeight){
                while(left < right && heights[right] <= rightHeight){
                    right--;
                }
            }
            if(minHeight == leftHeight){
                while(left < right && heights[left] <= leftHeight){
                    left++;
                }
            }
        }
        return max;

    }
}
