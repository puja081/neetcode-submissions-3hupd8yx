class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // **** using character frequency 
        // Map<String, List<String>> res = new HashMap<>();

        // for(String str : strs) {
        //     int[] freq = new int[26];
        //     for(char c : str.toCharArray()) {
        //         freq[c - 'a']++;
        //     }
        //     String key = Arrays.toString(freq);
        //     res.putIfAbsent(key, new ArrayList<>());
        //     res.get(key).add(str);
        // }
        // return new ArrayList<>(res.values());
          

        // using Sorting

        Map<String, List<String>> res = new HashMap<>();
        for(String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedS = new String(c);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
