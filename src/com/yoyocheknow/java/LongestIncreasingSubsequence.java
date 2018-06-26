package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 类说明
 *Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 给一组无序的数字，找到里面最大的上升子序列。
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
   Output: 4
   Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * @author zhangzhihua
 * @date 2018/6/26 18:29
 */
public class LongestIncreasingSubsequence {

//    设置动态规划数组dp[]，第i个状态dp[i]代表以第i个元素结尾的最长上升子序列的长度:
//    动态规划边界:dp[0] = 1；
//    初始化最长上升子序列的长度LIS = 1； 从1到n-1，循环i，计算dp[i]:
//    从0至i-1，循环j，若nums[i] > nums[j]，说明nums[i]可放置在nums[j]的
//    后面，组成最长上升子序列:
//    若dp[i] < dp[j] + 1:
//    dp[i] = dp[j] + 1
//    LIS为dp[0],dp[1],...,dp[i],...,dp[n-1]中最大的。

    public int lengthOfLIS(int[] nums) {

        if(nums.length==0)
        {
            return 0;
        }

        int LIS=1;
        int []dp=new int[nums.length];//dp[i]表示nums数组中以第i个数字结尾的最长子序列
        dp[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            dp[i]=1;//每个以nums[i]结尾的最长子序列初始化为1
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j]&&dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                }

            }
            if(LIS<dp[i])
            {
                LIS=dp[i];
            }
        }
        return LIS;
    }
//    设置一个栈(使用vector实现)stack，stack[i]代表长度为i+1的上升子序列最后一个元素的最小可能取值，
//    即若要组成长度为i+2的上升子序列，需要一个大于stack[i]的元素。最终栈的大小，即为最长上升子序列长度。
//    nums = [1, 3, 2, 3, 1, 4]
//    1.设置一个栈(使用vector实现)，将nums[0] push栈中。
//    2.从1至n-1遍历nums数组:
//       若nums[i] > 栈顶:将nums[i] push至栈中。
//          否则:
//             从栈底遍历至栈顶，若遍历时，栈中元素大于等于nums[i]， 使用nums[i]替换该元素，并跳出循环。
//    3.返回栈的大小。

    public int lengthOfLIS2(int[] nums) {
        if(nums.length==0)
            return 0;
        List<Integer> stack=new ArrayList<Integer>();
        stack.add(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>stack.get(stack.size()-1))
            {
                stack.add(nums[i]);
            }else {
                for (int j = 0; j <stack.size(); j++)
                {
                    if(stack.get(j)>=nums[i])
                    {
                        stack.set(j,nums[i]);
                        break;
                    }
                }
            }
        }
        return stack.size();
    }
}
