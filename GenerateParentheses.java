import java.util.*;

class GenerateParentheses {
    public void gen(String curr, int n, int open, int close, List<String> result) {
        if (curr.length() == n*2) {
            result.add(curr);
            return;
        }
        if (open > close) {
            gen(curr + ")", n, open, close + 1, result);
        }
        if (open < n) {
            gen(curr + "(", n, open + 1, close, result);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        gen("", n, 0, 0, result);
        return result;
    }
}
