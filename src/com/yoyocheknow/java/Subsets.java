package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * @author zhangzhihua
 * @date 2018/3/18 14:13
 */
public class Subsets {
   static List<List<Integer>> result=new ArrayList<List<Integer>>();
    static List<Integer> item=new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        generate(0,nums,item,result);
        return result;
    }
    public static void generate(int i,int[] nums,List<Integer> item,List<List<Integer>> result)
    {
        if(i>=nums.length)
        {
            return;
        }

        item.add(nums[i]);
        result.add(item);
        generate(i+1,nums,item,result);
        item.remove(i-1);
        generate(i+1,nums,item,result);
    }

    public static void main(String args[])
    {
        int[] nums={1,2,3};
        List<List<Integer>>result= subsets(nums);
        System.out.print("result="+result.toString());
    }
}
