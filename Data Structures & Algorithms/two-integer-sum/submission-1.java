class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length - 1; i++){
            int temp = target;
            temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (temp == nums[j]){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}
