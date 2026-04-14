class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using  hashMap
        HashMap<Character, Integer> prevIndexes = new HashMap<>();
        int l = 0 , res = 0;
        for(int r = 0 ; r < s.length() ; r++) {
            if(prevIndexes.containsKey(s.charAt(r)) && prevIndexes.get(s.charAt(r)) >= l) {
                l = prevIndexes.get(s.charAt(r)) + 1;
            }
            res = Math.max(res , r - l + 1);
            prevIndexes.put(s.charAt(r), r);
        }
        return res;
    }
}
