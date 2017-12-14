package com.yoyocheknow.java;

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
    public static String longestPalindrome(String s) {
        int low =0;
        int length=s.length();

    return "ss";
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
    public static void main(String args[])
    {

    }
}
