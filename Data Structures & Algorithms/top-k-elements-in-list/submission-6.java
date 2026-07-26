class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //number, count
        int[][] numCounts = new int[nums.length][2];
        Arrays.sort(nums);
        int index = 0; 

        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(currNum == numCounts[index][0]){
                numCounts[index][1] += 1; 
            } else {
                if(i > 0){
                    index++;
                }
                numCounts[index][0] = currNum;
                numCounts[index][1] = 1;
            }
        }

        Arrays.sort(numCounts, (a, b) -> Integer.compare(b[1], a[1]));

        int[] result = new int[k];

        for(int i = 0; i < k; i++){
            result[i] = numCounts[i][0];
        }

        return result; 

    }
}
