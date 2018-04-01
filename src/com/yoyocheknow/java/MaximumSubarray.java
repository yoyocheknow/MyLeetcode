package com.yoyocheknow.java;

/**
 * 类说明  最大字段和
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

     For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @author zhangzhihua
 * @date 2018/4/1 10:01
 */
public class MaximumSubarray {
    public static int  maxSubArray(int[] nums) {
        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        int max_res=dp[0];
        for(int i=1;i<nums.length;i++)
        {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max_res)
                max_res=dp[i];
        }
        return max_res;
    }
}
