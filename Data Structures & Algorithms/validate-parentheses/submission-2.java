class Solution {
    public boolean isValid(String s) {
        Map<String, String> brackets = new HashMap<>();
       
        brackets.put(")", "(");
        brackets.put("]","[");
        brackets.put("}", "{");

        Deque<String> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            String current = s.substring(i, i+1);
            if(brackets.get(current) == null){
                stack.push(current);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                String top = stack.pop();
                if(!top.equals(brackets.get(current))){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
        
    }
}
