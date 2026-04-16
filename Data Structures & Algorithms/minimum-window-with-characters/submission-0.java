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
