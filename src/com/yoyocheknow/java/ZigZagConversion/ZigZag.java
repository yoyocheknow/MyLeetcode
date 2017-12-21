package com.yoyocheknow.java.ZigZagConversion;

import java.util.Arrays;

/**
 * 类说明
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *  P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 用一个字符串数组 string[rows] 来存储每一行，最后一拼接就是最终结果。

 用一个delta表示正向还是反向，即上图中从第一行到最后一行还是最后一行到第一行
 * @author zhangzhihua
 * @date 2017/12/21 15:13
 */
public class ZigZag {
    public static String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows <= 1) return s;

        String[] ans = new String[nRows];
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= nRows) {//说明此时该折回换行了
                row = nRows-2;
                delta = -1;
            }
            if (row < 0) {//折到头以后重新开始
                row = 1;
                delta = 1;
            }
        }

        String ret = "";
        for (int i = 0; i < nRows; i++) {
            ret += ans[i];
        }
        return ret;
    }
    public static void main(String args[])
    {
        convert("0123456789",4);
    }
}
