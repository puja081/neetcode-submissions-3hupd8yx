class Solution {
    /*
    --> for every opening bracket, add its equivalent closing bracket to the stack.
    --> for every closing bracket, just look at the top of stack, if same pop the stack.
    */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '{'){
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else if(c == '(') {
                stack.push(')');
            } else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
    return stack.isEmpty();
         
    }
}
