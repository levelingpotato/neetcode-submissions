class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return findInt(max, piles, h);
    }
    public int findInt(int max, int[] piles, int h){
        int left = 1;
        int right = max;
        int min = max + 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            int hours = 0;
            for(int i = 0; i < piles.length; i++){
                int currPile = piles[i];
                if(piles[i] % mid > 0){
                    hours += piles[i] / mid + 1;
                } else {
                    hours += piles[i] / mid;
                }
            }

            if(hours > h){
                left = mid + 1;
            } else {
                min = mid;
                right = mid - 1;
            } 

        }
        return min;
    }
}
