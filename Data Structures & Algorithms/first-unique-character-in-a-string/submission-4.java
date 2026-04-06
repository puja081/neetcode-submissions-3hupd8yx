class Solution {
    public int firstUniqChar(String s) {
        //brute force
        // char[] c = s.toCharArray();
        // for(int i = 0 ; i < c.length; i++) {
        //     boolean found = true;
        //     for(int j = 0 ; j < c.length; j++) {
        //         if(i == j) {
        //             continue;
        //         }
        //         if(c[i] == c[j]) {
        //             found = false;
        //             break;
        //         }
        //     }
        //     if(found == true) {
        //         return i;
        //     }
        // }
        // return -1;

        //using HashMap
        // char[] c = s.toCharArray();

        Map<Character, Integer> count = new HashMap<>();
        // for(int i = 0 ; i < c.length ; i++) {
        //     count.put(c[i], count.getOrDefault(c[i], 0) + 1);
        // }
        // for(int i = 0 ; i < c.length ; i++) {
        //     if(count.get(c[i]) == 1) {
        //         return i;
        //     }
        // }
        //using HashMap optimal
        int n = s.length();
        for(int i = 0; i < n ; i++) {
            char c = s.charAt(i);
            if(!count.containsKey(c)){
                count.put(c, i);
            }
            else {
                count.put(c, n);
            }
        }
        int res = n;
        for(int i : count.values()){
            res = Math.min(i, res);
        }
    return res == n ? -1 : res;
    }

    
}