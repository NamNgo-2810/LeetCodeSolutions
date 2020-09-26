import java.util.*;
class FirstMissingPositive {
    // Problem 41: First Missing Positive
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        Set<Integer> set = new HashSet<>();
        boolean flag = true;
        int temp_min = 1;
        for (int num: nums) {
            set.add(num);
            if (num > 0) temp_min = Math.min(num, temp_min);
        }
        while (flag) {
            if (set.contains(temp_min)) temp_min++;
            else flag = false;
        }
        return temp_min;
    }
}
