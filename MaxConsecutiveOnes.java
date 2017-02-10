public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int startOne = 0;
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
                res = Math.max(res, i-startOne);
                startOne = i+1;
            }
        }
        res = Math.max(res, nums.length-startOne);
        return res;
    }
}
