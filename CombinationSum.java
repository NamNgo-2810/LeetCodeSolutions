import java.util.*;
class CombinationSum {
    // Problem 39: Combination Sum
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    ArrayList<Integer> temp=new ArrayList<Integer>();
    void sum(int [] a, int k, ArrayList<Integer> temp, int l)
    {
        if(k==0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(l>=a.length)
            return ;
        for(int i=l;i<a.length;i++)
        {
            if(k-a[i]>=0)
            {
                temp.add(a[i]);
                sum(a,k-a[i],temp,i);
                temp.remove(temp.size()-1);
            }
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum(candidates,target,temp,0);
        return res;

    }
}
