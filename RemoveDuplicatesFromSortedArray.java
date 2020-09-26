class RemoveDuplicatesFromSortedArray {
        // Problem 26: Remove Duplicates From Sorted Array
        public int removeDuplicates(int[] nums) {

            if(nums.length == 0 || nums == null) return 0;


            int result = 0;
            for(int i = 0; i < nums.length; ++i){

                if (i == 0 || nums[i] != nums[i - 1]){
                    nums[result++] = nums[i];
                }

            }
            return result;
        }
}

