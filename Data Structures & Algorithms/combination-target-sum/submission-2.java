class Solution {
    List<List<Integer>> results;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        results = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, target, 0, currList);
        return results;
    }

    public void backtrack (int[] nums, int target, int index, List<Integer> currList){
        if(target == 0){
            results.add(new ArrayList(currList));
            return;
        }
        if(target < 0 || index >= nums.length){
            return;
        }
        currList.add(nums[index]);
        backtrack(nums, target - nums[index], index, currList);
        currList.remove(currList.size() - 1);
        backtrack(nums, target, index + 1, currList);
    }
}
