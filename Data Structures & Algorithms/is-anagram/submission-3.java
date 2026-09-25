class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] a = s.toCharArray();
        // char[] b = t.toCharArray();
        // Arrays.sort(a);
        // Arrays.sort(b);
        // if(Arrays.equals(a,b)) {
        //     return true;
        // } else {
        //     return false;
        // }
         if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26]; 
        for(int i = 0 ; i < s.length() ; i++) {
                  
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int x : count) {
            if(x != 0){
                return false;
            }
        }
        return true;
        


    }
}
