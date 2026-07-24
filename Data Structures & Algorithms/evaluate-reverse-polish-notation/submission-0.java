class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> ints = new ArrayDeque<>();

        
        for(String token : tokens){
            boolean isOperator = false;
            int number = 0;
            try{
                number = Integer.parseInt(token);
            } catch (Exception e){
                isOperator = true;
            }
            int result = 0;

            if(isOperator){
                int b = ints.pop();
                int a = ints.pop();

                switch(token){
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }
                ints.push(result);
            } else {
                ints.push(number);
            }
        }

        return ints.peek();
    }
}
