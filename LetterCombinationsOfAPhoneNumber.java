import java.util.*;

class LetterCombinationsOfAPhoneNumber {
    // Problem 17: Letter Combinations of a Phone Number
    String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void dfs(String digits, int i, StringBuilder sb, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int idx = Character.getNumericValue(digits.charAt(i));
        for (int j = 0; j < letters[idx].length(); j++) {
            sb.append(letters[idx].charAt(j));
            dfs(digits, i + 1, sb, res);
            sb.delete(sb.length()-1, sb.length());
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }
}
