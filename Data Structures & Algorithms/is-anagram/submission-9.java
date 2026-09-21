class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        Arrays.sort(sCh);
        Arrays.sort(tCh);
        
        if(sCh.length != tCh.length){
            return false;
        }
        s = new String(sCh);
        t = new String(tCh);
        return s.equals(t);
        
    }
   
}
