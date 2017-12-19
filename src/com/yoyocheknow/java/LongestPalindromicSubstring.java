package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 类说明
 * 判断字符串中的最长回文
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 *
 *
 * @author zhangzhihua
 * @date 2017/12/14 12:07
 */
public class LongestPalindromicSubstring {
    //第一种解法，用递归的方法判断选取的字符串是否是回文，然后循环遍历，最后找找到最长的那个。
    //这种暴力的解法结果就是。。。超时。
    public static String longestPalindrome(String s) {
       // int low =0;
        int length=s.length();
        ArrayList<String> array= new ArrayList<>();
        for(int low =0;low<length;low++)
        {
            for(int high=low;high<length;high++)
            {
                if(isPalindromic(low,high,s,high-low+1))
                {
                    array.add(s.substring(low,high+1));
                    //System.out.print(array.toString());
                }
            }
        }
        String temp="";
        temp=array.get(0);
        for(int i=1;i<array.size();i++)
        {

            if(temp.length()<array.get(i).length())
            {
                temp=array.get(i);
                System.out.println("temp="+temp);
            }
        }

        System.out.println(array.toString());
    return temp;
    }

    public static boolean isPalindromic(int low,int high,String s,int length)
    {
        if(length==1||length==0)
        {
            return true;
        }
        if(s.charAt(low)!=s.charAt(high))
        {
            return false;
        }
        return isPalindromic(low+1,high-1,s,length-2);
    }

//方法二
    public static String longestPalindrome2(String s) {
        // int low =0;
        int length=s.length();
        for(int size =length;size>0;size--)
        {
            for(int low=0,high=low+size-1;high<length;low++,high++)
            {
                if(isPalindromic2(s,low,high))
                {
                   return s.substring(low,high+1);
                }
            }
        }

        return s.substring(0,1);
    }

    public static boolean isPalindromic2(String s,int low,int high)
    {
        while (low<=high)
        {
            if(s.charAt(low)==s.charAt(high))
            {
                low++;
                high--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        String s =longestPalindrome2("abcaabb");
        System.out.println("s="+s);
    }
}
