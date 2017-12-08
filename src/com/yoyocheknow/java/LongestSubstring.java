package com.yoyocheknow.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 类说明
 *
 *Given a string, find the length of the longest substring without repeating characters
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 求一个字符串的最长的无重复子字符串
 * 总体思路是：声明一个arrayList来存放最长的字符串，每准备新加一个字符，就和之前的list中的字符比较，如果都不一致那么就加入。并记录每次list的长度，最后拿最长的即可。
 * @author zhangzhihua
 * @date 2017/12/6 17:57
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] param = s.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        int length=0;

        for(int i=0;i<param.length;i++)
        {

            list.add(param[i]);
            if(i+list.size()>param.length)//防止出现最后一串没有重复字符，在加入list后还从i+1加入新字符串的情况。示例“pwwkew”
            {
                break;
            }
            array.add(list.size());
            out:
            for(int j=i+1;j<param.length;j++)
            {
                for(int k=0;k<list.size();k++)//判断下一个字符是否有与list中一致的，一致则跳出循环，记录长度、存档
                {
                    if(param[j]==list.get(k))
                    {
                        array.add(list.size());
                        list.clear();
                        break out;//下一个字符和list中有一致的，记录这次的list长度，跳出循环，从第i+1个再开始

                    }else{
                        if(k==(list.size()-1))//这么设置的目的是要加入的字符和list中比对一遍后没有一个和list中一致的，那么就在list中添加这个字符，并跳出这个循环
                        {
                            list.add(param[j]);//如果下一个字符与list中没有一致的，则存入list中，然后继续往下面进行
                            break;
                        }
                    }
                }
                array.add(list.size());
            }
        }
        Collections.sort(array);
        if(array.size()<1)
        {
            return 0;
        }else{
            return array.get(array.size()-1);
        }

    }
    //官网给出的一种解法，虽然时间复杂度也是O的3次方，但是比上面的那种解法好理解也简单。
    public static int lengthOfLongestSubstring1(String s)
    {
        char[] param = s.toCharArray();
        int max=0;
        for(int i=0;i<param.length;i++)
        {
            for(int j=i+1;j<=param.length;j++)
            {
                if(isSubString(s,i,j))
                    max=Math.max(max,j-i);
            }
        }
        return max;
    }

    public static boolean isSubString (String s,int start,int end)//判断字符串s，从start到end位之间是否有重复字符
    {
        Set<Character> set = new HashSet<>();//用set来存放字符，以便于好查找重复字符
        for(int i=start;i<end;i++)
        {
            if(set.contains(s.charAt(i)))
                return false;
            set.add(s.charAt(i));
        }
        return true;

    }
    //第三种解决方法，时间复杂度为O1，思想是用一个滑动窗口来实现，用hashset来当作窗口，每向后移动一位，就判断窗口hashset里面有没有，没有的话
    //向后延展，如果有重复字符，那么窗口第一位向前移动一位，知道窗口hashset里面没有重复字符。
    public static int lengthOfLongestSubstring2(String s)
    {
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0,max=0;
        int n=s.length();
        while (i<n&&j<n)
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                max=Math.max(max,j-i);
            }
            else{
                set.remove(s.charAt(i++));
            }

        }
        return max;
    }
    public static void main(String arg[])
    {
        int len = lengthOfLongestSubstring2("abcbabcbb");
        System.out.println("len="+len);
    }
}
