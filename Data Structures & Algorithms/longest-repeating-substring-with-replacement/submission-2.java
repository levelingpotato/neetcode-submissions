class Solution {
    public int characterReplacement(String s, int k) {
        

        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int longest = 0;
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        String majority = "";
        Map<String, Integer> tracker = new HashMap<>();
        tracker.put(majority, 0);

        while(right < s.length()){
            String current = s.substring(right, right+1);

            if(tracker.containsKey(current)){
                tracker.put(current, tracker.get(current) + 1);
            } else {
                tracker.put(current, 1);
            }
            maxFreq = Math.max(maxFreq, tracker.get(current));

            int windowLength = s.substring(left, right + 1).length();
            while(windowLength - maxFreq > k){
                String curLeft = s.substring(left, left + 1);
                tracker.put(curLeft, tracker.get(curLeft) - 1);
                
                left++;
                windowLength = s.substring(left, right + 1).length();
            }
            int length = s.substring(left, right + 1).length();
            if( length > longest){
                longest = length;
            }
            right++;
        }
        return longest;
    }
}
