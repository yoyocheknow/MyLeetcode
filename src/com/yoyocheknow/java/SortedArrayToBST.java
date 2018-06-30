package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    给一个有序数组，转化成一个平衡二叉排序树
 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Given the sorted array: [-10,-3,0,5,9],
 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
       0
      / \
    -3   9
   /    /
  -10  5

 * @author zhangzhihua
 * @date 2018/6/30 17:01
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length-1);
    }

    public TreeNode  helper(int[] nums, int low, int high)
    {
        if(low>high || high<0 || low>=nums.length)
            return null;
        int index = (low + high)/2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, low,index-1);
        node.right = helper(nums, index+1, high);
        return node;
    }


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

