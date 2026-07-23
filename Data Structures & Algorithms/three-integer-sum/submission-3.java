class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int leftPointer = i + 1;
        
            int rightPointer = nums.length - 1;
            while(leftPointer < rightPointer){
                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];

                if(sum < 0){
                    leftPointer++;
                }
                if(sum > 0){
                    rightPointer--;
                }
                if(sum == 0){
                    results.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));
                    while(leftPointer < rightPointer && nums[leftPointer + 1] == nums[leftPointer]){
                        leftPointer++;
                    }
                    while(leftPointer < rightPointer && nums[rightPointer - 1] == nums[rightPointer]){
                        rightPointer--;
                    }
                    leftPointer++;
                    rightPointer--;

                }
            }
        }
        return results;
    }
}
