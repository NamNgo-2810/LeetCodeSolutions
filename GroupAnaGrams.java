import java.util.*;
class GroupAnaGrams {
    // Problem 49: Group Anagrams
    public Map<Character, Integer> freqChar(String str) {
        Map<Character, Integer> ans = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = ans.getOrDefault(str.charAt(i), 0);
            ans.put(str.charAt(i), count+1);
        }
        return ans;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> freqs = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str: strs) {
            Map<Character, Integer> map = freqChar(str);
            if (!freqs.containsKey(map)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                freqs.put(map, list);
            }
            else freqs.get(map).add(str);
        }
        for (Map<Character, Integer> key: freqs.keySet()) {
            res.add(freqs.get(key));
        }
        return res;
    }
}
