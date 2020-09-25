import java.util.*;

class LengthOfLongestSubstring {
    // Problem 3: Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> used = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (used.contains(s.charAt(i))) {
                while (used.contains(s.charAt(i))) {
                    used.remove(queue.poll());
                }
            }
            queue.offer(s.charAt(i));
            used.add(s.charAt(i));
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
