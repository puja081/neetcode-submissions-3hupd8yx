class Solution {
    public boolean isValid(String s) {
        /*
        --> Valid parentheses must follow a last-opened, first-closed order — just like stacking plates.
So we use a stack to track opening brackets.
Whenever we see a closing bracket, we simply check whether it matches the most recent opening bracket on top of the stack.
If it matches, we remove that opening bracket.
If it doesn't match (or the stack is empty), the string is invalid.
A valid string ends with an empty stack.
        */
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(')','(');
        closeToOpenMap.put('}','{');
        closeToOpenMap.put(']','[');
        for(char c : s.toCharArray()){
            if(closeToOpenMap.containsKey(c)){
                if(!stack.isEmpty() && closeToOpenMap.get(c) == stack.peek()) {
                    stack.pop();
                } 
                else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
        
    }
}
