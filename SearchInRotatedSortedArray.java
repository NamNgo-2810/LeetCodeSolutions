class SearchInRotatedSortedArray {
    // Problem 33: Search in Rotated Sorted Array
    public int search(int[] A, int x) {
        int left = 0, right = A.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == x) return mid;
            else if (A[mid] < A[right]) {
                if (x > A[mid] && x <= A[right]) left = mid+1;
                else right=mid-1;
            }

            else {
                if (mid > 0 && x >= A[left] && x <= A[mid-1]) right = mid-1;
                else left = mid+1;
            }
        }
        return -1;
    }
}
