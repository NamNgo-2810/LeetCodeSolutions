import java.util.*;

class ThreeSum {
    //Problem 15: 3 Sum
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue; // skip duplicate elements
            TwoSum(nums,i);
        }
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    public void TwoSum(int []nums,int k) {
        int no =-(nums[k]);
        int i=k+1,j=nums.length-1;
        while(i<j) {
            if(nums[i]+nums[j]>no) j--;
            else if(nums[i]+nums[j]<no) i++;
            else{
                ans.add(Arrays.asList(nums[k],nums[i],nums[j]));
                while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j]==nums[j-1]) j--;
                i++; j--;
            }
        }
    }
}
