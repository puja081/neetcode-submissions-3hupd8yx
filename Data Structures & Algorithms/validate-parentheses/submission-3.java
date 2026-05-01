class Solution {
    public boolean isValid(String s) {
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
