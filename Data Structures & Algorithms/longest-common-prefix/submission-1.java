// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         Arrays.sort(strs);
//         StringBuilder result = new StringBuilder();
//         char[] firstString = strs[0].toCharArray();
//         char[] lastString =  strs[strs.length-1].toCharArray();
//         for(char i = 0 ; i < firstString.length ; i++){
//             if(firstString[i] != lastString[i]) {
//                 break;
//             }
//             result.append(firstString[i]);
//         }
//         return result.toString();
//     }
// }
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
}
class Trie {
    TrieNode root = new TrieNode();
    void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
    }

    int lcp(String word, int prefixLen) {
        TrieNode node = root;
        int i = 0;
        while (i <  Math.min(word.length(), prefixLen)){
            if(!node.children.containsKey(word.charAt(i))) {
                return i;
            }
            node = node.children.get(word.charAt(i));
            i++;
        }
       return Math.min(word.length(), prefixLen);

    }
}
class Solution {
public String longestCommonPrefix(String[] strs) { 
    if(strs == null || strs.length == 0) return "";
    if(strs.length == 1){
        return strs[0];
    }
    int mini = 0;
    for(int i = 0; i < strs.length; i++) {
        if(strs[mini].length() > strs[i].length()) {
            mini = i;
        }
    }
    Trie trie = new Trie();
    trie.insert(strs[mini]);
    int prefLength = strs[mini].length();
    for(int i = 0 ; i < strs.length ; i++){
        prefLength = trie.lcp(strs[i], prefLength);
    }
    return strs[mini].substring(0, prefLength);
   }
}