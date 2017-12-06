package com.yoyocheknow.java;

/**
 * 类说明
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

   You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].

 * @author zhangzhihua
 * @date 2017/12/4 17:43
 */
public class TwoSum {

    public static  int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        int length =nums.length;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }

        }

        return result;
    }

    public static void main(String args[])
    {
        int param[]={2,7,11,15};
        int rs[] = twoSum(param,26);
        System.out.print("int []="+rs[0]+","+rs[1]);
    }
}
