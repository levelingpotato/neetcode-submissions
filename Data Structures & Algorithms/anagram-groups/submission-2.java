class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        Map <String, ArrayList<String>> anagrams = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            if(anagrams.get(sorted) != null){
                anagrams.get(sorted).add(strs[i]);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                anagrams.put(sorted, newList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()){
            result.add(entry.getValue());
        }
        return result;
}
}
