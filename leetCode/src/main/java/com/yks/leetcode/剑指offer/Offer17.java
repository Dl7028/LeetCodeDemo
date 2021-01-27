package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 17. 打印从1到最大的n位数
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/26 16:10
 */
public class Offer17 {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * 示例 1:
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     *
     * 说明：
     *
     * 用返回一个整数列表来代替打印
     * n 为正整数
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 考虑到大数情况,全排列方式，yon0...9依次排列，
     * 用start标记记录 num实际上的数字，防止00...09前面0的出现
     * @param
     * @return
     */
    class Solution {

        StringBuilder res;
        int count = 0;
        int[] result;
        int n,start,nine;
        char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'},num;
        public int[] printNumbers(int n) {
            this.n = n;
            start = n-1;
            num = new char[n];
            result = new int[(int) Math.pow(10,n)-1];
            res = new StringBuilder();
            dfs(0);
            res.deleteCharAt(res.length()-1);
            return result;
        }
        void dfs(int x) {
            if (x==n){
                String s = String.valueOf(num).substring(start);
                if (!s.equals("0")) {
                    res.append(s).append(",");
                    result[count++] = Integer.parseInt(s);
                }
                if (n-start == nine) start--;
                return ;
            }
            for(char i:loop){
                if (i=='9') nine++;
                num[x] = i;
                dfs(x+1);
            }
            nine--;
        }
    }


}
