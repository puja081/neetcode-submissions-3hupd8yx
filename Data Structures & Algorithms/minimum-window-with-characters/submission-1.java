/*Intuition (Crisp for revision)
Build frequency map of pattern (pat)
Expand window using j until all required chars are matched
Use count to track how many unique chars are still unmet
Once count == 0 → valid window found
Try shrinking from left (i) to get minimum window
Keep updating smallest substring

👉 Core idea:

“Expand to satisfy condition, shrink to optimize length”
What count means
count = number of unique chars still not fully matched
When count == 0 → window is valid
Dry Intuition (1-liner)

Maintain a window that contains all pattern characters, then shrink it to find the smallest valid window.

⏱️ Time Complexity

Let:

n = length of s
m = length of pat
Breakdown:
j runs from 0 → n → O(n)
i also moves at most n times → O(n)
Each operation inside loop → O(1)
✅ Final Time Complexity:
O(n)

✔️ Each character is processed at most twice

📦 Space Complexity
O(k)
k = number of unique chars in pattern
In worst case → O(26) (if lowercase letters)

👉 So effectively:

O(1)
*/


class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()){
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> windowSize = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int need = countT.size();
        int i = 0 , j = 0;
        String result = "";
        int min = Integer.MAX_VALUE;
        while( j < s.length())  {
            char rightChar = s.charAt(j);
            if(countT.containsKey(rightChar)) {
                countT.put(rightChar, countT.get(rightChar) - 1);
                if(countT.get(rightChar) == 0){
                    need--;
                }
            }

            while(need == 0) {
                if(j-i+1 <  min) {
                    min = j-i+1;
                    result = s.substring(i, j+1);
                }
                char leftChar = s.charAt(i);
                if(countT.containsKey(leftChar)) {
                    if(countT.get(leftChar) == 0){
                        need++;
                    }
                    countT.put(leftChar, countT.get(leftChar) + 1);
                }
                i++;
            }
            j++;
        }
        
        return result;
    }
}
