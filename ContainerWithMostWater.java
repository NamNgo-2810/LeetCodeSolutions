class ContainerWithMostWater {
    // Problem 11: Container With Most Water
    public int maxArea(int[] height) {
        int r = height.length - 1;
        int l = 0;
        int result = 0;
        while (l < r) {
            int area = Math.min(height[r], height[l])*(r-l);
            result = Math.max(result, area);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return result;
    }
}
