import java.util.*;
class ValidParentheses {
    // Problem 20: Valid Parentheses
    Map<Character,Character> map;
    public ValidParentheses() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) stack.push(c);
            else {
                if (stack.isEmpty() || map.get(stack.pop()) != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
