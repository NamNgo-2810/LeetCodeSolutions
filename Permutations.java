import java.util.*;
class Permutations {
    // Problem 46: Permutations
    public void swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }
    public void permute(int[] data, int start, List<List<Integer>> result) {
        if (start == data.length-1) {
            List<Integer> P = new ArrayList<>();
            for (int num: data) {
                P.add(num);
            }
            result.add(P);
        }
        else {
            for (int i = start; i < data.length; i++) {
                swap(data, i, start);
                permute(data, start+1, result);
                swap(data, i, start);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        permute(nums, 0, result);
        return result;
    }
}
