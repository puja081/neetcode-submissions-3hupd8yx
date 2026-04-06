class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                newStr.append(Character.toLowerCase(c));
            }
        }
        StringBuilder rev = new StringBuilder(newStr.toString());
        rev.reverse();
        return newStr.toString().equals(rev.toString());
        
    }
}
