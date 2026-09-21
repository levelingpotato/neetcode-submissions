class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(sMap.containsKey(curr)){
                sMap.put(curr, sMap.get(curr) + 1);
            } else {
                sMap.put(curr, 1);
            }
        }
        for(int i = 0; i < t.length(); i++){
            char curr = t.charAt(i);
            if(sMap.containsKey(curr)){
                int val = sMap.get(curr);
                if(val == 1){
                    sMap.remove(curr);
                } else {
                    sMap.put(curr, val - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
