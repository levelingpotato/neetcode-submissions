class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int mid = left + ((right - left) / 2);
        int minimum = nums[mid];
        while (left < right) {
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                right = mid;
            }
            System.out.println("Mid: " + mid + " Left " + left + "Right " + right);
            mid = left + (right - left) / 2;
        }


        return nums[left];
    }
}
