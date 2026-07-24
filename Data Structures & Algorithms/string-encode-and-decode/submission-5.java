class Solution {

    public String encode(List<String> strs) {
        String code = "";
        
        for(String str : strs){
           code += str.length() + "#" + str;
        }
        return code;
    }

    public List<String> decode(String str) {
        List<String> results = new ArrayList<>();
        int i = 0; 
        while (i < str.length()){
            int j = str.indexOf("#", i);
            int size = (Integer.parseInt(str.substring(i, j)));
            results.add(str.substring(j + 1, j + size + 1));
            i = j + size + 1;
        }
        return results;
    }
}
