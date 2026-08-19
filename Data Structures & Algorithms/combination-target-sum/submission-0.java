class Solution {
    List<List<Integer>> results;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        results = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<>();
        
        backtrack(nums, target, currList, 0);
        return results;
    }

    public void backtrack(int[] nums, int target, List<Integer> currList, int i){
        if(target == 0){
            results.add(new ArrayList(currList));
            return;
        }
        if (target < 0 || i >= nums.length){
            return;
        }
        currList.add(nums[i]);
        backtrack(nums, target - nums[i], currList, i);
        currList.remove(currList.size() - 1);
        backtrack(nums, target, currList, i + 1);
    }
}
