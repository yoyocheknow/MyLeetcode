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

//方法二，是对方法一循环查找的优化 ：1、从最长的子串开始遍历，一旦找到一个回文，就终止迭代。
//                                 2、判断回文采用收缩法。从最长的串开始，遍历到每一个单独的字符。
// 假设字符串长度为n,第一次判断长度为n的字符串是否是回文，是则返回，不是则进行下次循环找字符串中所有长度为n-1的字符串是否是回文。
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

    //方法三，从字符中心遍历.
    //回文就是中心对称的单词.从字符的中心开始，向两边扩散检查回文。这需要维护一个指针，从头开始，以每一个位置为中心遍历一遍。
    //这比暴力遍历所有子串省了很多重复判断。以某个字符为核心一旦探测到边界，更长的的串就都不再考虑。复杂度O(n^2)。
    // 注意，回文需要同时检查单核`aba`以及双核`abba`的情况。


    static int  max=0;
    static String rex = "";
    public static String longestPalindrome3(String s) {
        int length =s.length();
        for(int i=0;i<length-1;i++)
        {
            isPalindromic3(s,i,i);
            isPalindromic3(s,i,i+1);
        }
        return rex;
    }

    public static void isPalindromic3(String s,int low,int high)
    {
        while (low>=0&&high<s.length())
        {
            if(s.charAt(low)==s.charAt(high))
            {
                if(high-low+1>max)
                {
                    max=high-low+1;
                    rex=s.substring(low,high+1);
                }
                low--;
                high++;
            }else
                return;

        }
    }
    public static void main(String args[])
    {
        String s =longestPalindrome3("abcaabb");
        System.out.println("s="+s);
    }
}
