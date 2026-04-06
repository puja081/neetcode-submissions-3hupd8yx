class Solution {
    public boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'
        || c >= '0' && c <= '9') ;
    }
    public boolean isPalindrome(String s) {
        // StringBuilder newStr = new StringBuilder();
        // for(char c : s.toCharArray()){
        //     if(Character.isLetterOrDigit(c)){
        //         newStr.append(Character.toLowerCase(c));
        //     }
        // }
        // StringBuilder rev = new StringBuilder(newStr.toString());
        // rev.reverse();
        // return newStr.toString().equals(rev.toString());  

        int i = 0, j = s.length() - 1 ;
        while(i < j) {
            char s1 = s.charAt(i);
            char s2 = s.charAt(j);
            if(!isAlphanumeric(s1)) {
                i++;
                continue;
            }
            if(!isAlphanumeric(s2)) {
                j--;
                continue;
            }
            if(Character.toLowerCase(s1) != Character.toLowerCase(s2)) {
                return false;
            }
            i++;
            j--;
        }  
        return true;  
    }
}
