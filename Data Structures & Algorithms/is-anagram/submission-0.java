class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        /*sorting*/
        // char[] s1 = s.toCharArray();
        // char[] s2 = t.toCharArray();
        // Arrays.sort(s1);
        // Arrays.sort(s2);
        // return Arrays.equals(s1, s2); // TC - O(nlogn + mlogm) and SC - O(1) or O(n)

        /*hashmap*/
        // HashMap<Character, Integer> s1 = new HashMap();
        // HashMap<Character, Integer> s2 = new HashMap();
        // for(int i = 0; i < s.length() ; i++){
        //     s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i),0)+1);
        //     s2.put(t.charAt(i), s2.getOrDefault(t.charAt(i),0)+1);
        // }
        // return s1.equals(s2); //TC - O(n+m) or SC(1)

        /* HashTable using Array */

        int[] count = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) -'a']++;
            count[t.charAt(i)-'a']--;

        }
        for(int val : count) {
            if(val != 0) {
                return false;
            }
        }
        return true;

    }
}
