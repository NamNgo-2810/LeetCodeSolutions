class FindMedianSortedArrays {
    // Problem 4: Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;

        if (l1 > l2) {
            int tmpL = l1;
            l1 = l2;
            l2 = tmpL;

            int[] tmpNum = nums1;
            nums1 = nums2;
            nums2 = tmpNum;
        }

        int s = 0, e = l1;
        int leftMax = 0, rightMin = 0;
        while(s <= e) {
            int i = (s + e) / 2;
            int j = (l1 + l2 + 1) / 2 - i;

            if (i > 0 && j < l2 && nums1[i-1] > nums2[j]) {
                e = i-1;
            }
            else if (j > 0 && i < l1 && nums2[j-1] > nums1[i]) {
                s = i+1;
            }
            else {
                if (i == 0) {
                    leftMax = nums2[j-1];
                }
                else if(j == 0) {
                    leftMax = nums1[i-1];
                }
                else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((l1 + l2) % 2 == 1) {
                    return leftMax;
                }

                if (i == l1) {
                    rightMin = nums2[j];
                }
                else if(j == l2) {
                    rightMin = nums1[i];
                }
                else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }

                return (leftMax + rightMin)/2.0;
            }


        }
        return 0.0;
    }
}
