package com.yoyocheknow.java;

import java.util.Arrays;

/**
 * 类说明
 *  已知一些孩子和一些糖果，每个孩子有需求因子g，每个糖果有大小s，当 某个糖果的大小s >=某个孩子的需求因子g时，
 *  代表该糖果可以满足该孩子；求使用这 些糖果，最多能满足多少孩子？(注意，某个孩子最多只能用1个糖果满足)
    例如，需求因子数组g = [5, 10, 2, 9, 15, 9]；糖果大小数组s = [6, 1, 20, 3, 8]；最多可以 满足3个孩子。

 * @author zhangzhihua
 * @date 2018/3/10 8:52
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child=0;
        int cookie=0;
        while(child<g.length&&cookie<s.length)
        {
            if(g[child]<=s[cookie])
            {
                child++;
                cookie++;
            }else{
                cookie++;
            }
        }
        return child;
    }
}
