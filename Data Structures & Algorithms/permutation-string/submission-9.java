class Solution {
    /*Intuition (Quick Lines)
Fix window size = len(s1)
Compare frequency of s1 with **frequency of current window in s2`
Slide window:
Remove left char
Add right char
If frequencies match → anagram found → return true

👉 Core idea:

“Don’t generate permutations, just check frequency match in a sliding window”

🔁 Pattern
Build freq(s1)
Build freq(first window of s2)

for each window:
    if match → return true
    remove left char
    add right char
⏱️ Time Complexity
O(n * 26) ≈ O(n)
n = length of s2
26 = constant (alphabets)
📦 Space Complexity
O(1)
Fixed size arrays (26)
🔥 One-line takeaway

Sliding window + frequency match = anagram detection in O(n)*/


    public boolean isMatched(int[] map1, int [] map2) {
        for(int i = 0; i < 26 ; i++) {
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(n < m){
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for(int i = 0 ; i < m ; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        if(isMatched(map1, map2)) {
                return true;
            }
        for(int i = 1 ; i <= n-m ; i++){
            map2[s2.charAt(i-1) - 'a']--;
            map2[s2.charAt(i+m-1) - 'a']++;

            if(isMatched(map1, map2)) {
                return true;
            }

        }
        return false;
        
    }

}
