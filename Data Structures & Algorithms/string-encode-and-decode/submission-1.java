class Solution {

    public String encode(List<String> strs) {
        //Instead of storing all string length first,
        //for every string we will strore length#String # will act as clear boundary b/w length and content
        StringBuffer res = new StringBuffer();
        for(String str: strs){
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        //use two pinters i and j and find substring using length.
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while( i < str.length()) { 
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i,j));
            i = j;
        }
    
        return res;

    }
}
