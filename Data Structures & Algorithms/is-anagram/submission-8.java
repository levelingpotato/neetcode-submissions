class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<String, Integer> valid = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(valid.get(s.substring(i, i+1)) == null){
                valid.put(s.substring(i, i+1), 1);
            } else {
                valid.put(s.substring(i, i+1), valid.get(s.substring(i, i+1)) + 1);
            }
        }
        System.out.println(valid);
        for(int i = 0; i < t.length(); i++){
            if(valid.get(t.substring(i, i+1)) == null || valid.get(t.substring(i, i+1)) == 0){
                return false;
            }
            if(valid.get(t.substring(i, i+1)) != null && valid.get(t.substring(i, i+1)) > 0){
                valid.put(t.substring(i, i+1), valid.get(t.substring(i, i+1)) - 1);
            }
        }
        
        return true;
    }
}
