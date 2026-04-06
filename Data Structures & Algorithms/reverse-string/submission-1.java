class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        // while(l < r) {
        //     char temp = s[l];
        //     s[l] = s[r];
        //     s[r] = temp;
        //     l++;
        //     r--;
        // }
        reverseStringRec(s, l, r); 
    }
    public void reverseStringRec(char[] s, int l, int r) {
        if(l < r){
            reverseStringRec(s, l + 1, r - 1);
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }
}