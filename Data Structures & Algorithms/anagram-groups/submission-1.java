class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        // for(String s : strs ){
        //     char[] charArray = s.toCharArray();
        //     Arrays.sort(charArray);
        //     String sortedS = new String(charArray);
        //     anagramMap.putIfAbsent(sortedS, new ArrayList());
        //     anagramMap.get(sortedS).add(s);
        // }
        // return new ArrayList<>(anagramMap.values());
     
        for(String s : strs) {
            int[] count = new int[26];
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(s);
        } 
      return new ArrayList<>(anagramMap.values());  
    }
}
