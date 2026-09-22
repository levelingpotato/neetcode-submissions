class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
                continue;
            }
            int diff = prices[i] - min;
            if(diff > max){
                max = diff;
            }
            
        }
        return max;
    }
}
