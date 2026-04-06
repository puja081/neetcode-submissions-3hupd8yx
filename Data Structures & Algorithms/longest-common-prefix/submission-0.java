class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        char[] firstString = strs[0].toCharArray();
        char[] lastString =  strs[strs.length-1].toCharArray();
        for(char i = 0 ; i < firstString.length ; i++){
            if(firstString[i] != lastString[i]) {
                break;
            }
            result.append(firstString[i]);
        }
        return result.toString();
    }
}