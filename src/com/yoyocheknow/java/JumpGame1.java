package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.
 一个数组存储了非负整型数据，数组中的第i个元素nums[i]，代表了可以从数组第i 个位置最多向前跳跃nums[i]步；
 已知数组各元素的情况下，求是否可以从数组的第 0个位置跳跃到数组的最后一个元素的位置?
 nums = [2, 3, 1, 1, 4, ...]
 * @author zhangzhihua
 * @date 2018/6/6 20:37
 */
public class JumpGame1 {
    public static boolean method(int[] nums)
    {
        if(nums.length<2)
        {
            return true;
        }
        int max_index=nums[0];
        int jump=0;
        int[] index=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            index[i]=i+nums[i];
        }
        while(jump<nums.length&&jump<=max_index)
        {
            if(max_index<index[jump])
            {
                max_index=index[jump];
            }
            jump++;
        }
        if(jump==index.length)
        {
            return true;
        }
        return false;
    }
}
