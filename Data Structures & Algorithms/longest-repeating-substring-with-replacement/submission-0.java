class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int windowSize = 0 ;
        int maxFreqCount = 0;
        int res = 0, l = 0;
        for(int r = 0 ; r < s.length() ; r++) {
            freqMap.put(s.charAt(r), freqMap.getOrDefault(s.charAt(r), 0) + 1);
            maxFreqCount = Math.max(maxFreqCount, freqMap.get(s.charAt(r)));
            windowSize = r - l + 1;

            if(windowSize - maxFreqCount > k) {
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)-1));
                l++;
            }
            windowSize = r - l + 1;
            res = Math.max(res,windowSize); 
        }
        return res;
    }
}
