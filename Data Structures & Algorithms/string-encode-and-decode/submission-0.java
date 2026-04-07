class Solution {

    public String encode(List<String> strs) {
        // 1st way - to record the length of the string followed by 
        //special separator and then append all strings together
        List<Integer> sizes = new ArrayList<>();
        StringBuffer res = new StringBuffer();
        for(String str : strs){
            sizes.add(str.length());
        }
        for(int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for(String str: strs){
            res.append(str);
        }
        return res.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuffer curr = new StringBuffer();
            while(str.charAt(i) != ',') {
                curr.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(curr.toString()));
            i++;
        }
        i++;
        for(int size : sizes){
            res.add(str.substring(i,i+size));
            i += size;
        }
        return res;
    }
}
