package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 14- I. 剪绳子
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/24 21:20
 */
public class Offer14_I {
    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 示例 1：
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 方法一：递归 （超时）
     * 判断 i*（n-i）的值 与 i*cuttingRope（n-i）的值哪个大
     * 即判断要不要进行递归
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if (n==2) return  1;
        int res = 0;
        for (int i=2; i<n; i++){
            int temp = Math.max(i*cuttingRope1(n-i),i*(n-i));
            res = Math.max(res,temp);
        }
        return res;
    }

    /**
     * 方法二：备忘录递归
     * @param n
     * @return
     */
    public int cuttingRope2(int n){
        int[] s = new int[n+1];
        s[2] = 1;
        return get(s,n);
    }
    public int get(int[] s , int n){
        if (s[n]!=0) {
            return s[n];
        }
        int res = 0;
        for(int i=2;i<n;i++){
            int temp = Math.max(i*get(s,n-i),i*(n-i));
            res = Math.max(res,temp);
        }
        s[n]= res;
        return s[n];
    }

    /**
     * 方法三：动态规划
     * dp[i] = max(j*(i-j),j*dp[i-j])
     * @param n
     * @return
     */
    public int cuttingRope3(int n){
        int dp[] = new int[n+1];
        for(int i =2;i<n+1;i++){
            for(int j=1;j<i;j++){
                int temp = Math.max(j*(i-j),j*dp[i-j]);
                dp[i] = Math.max(dp[i],temp);
            }
        }
        return dp[n];
    }

    /**
     * 方法四：贪婪算法
     *  当n>=5是尽可能的切分为3
     *  当n=4时，不能切分为3,1，需要切分为2，2
     *  假设切分为3的数量是k，切分为2的数量为m
     *  则结果为3^k*2^m
     * @param n
     * @return
     */
    public int cuttingRope4(int n){
        if (n==2) return 1;
        if(n==3)return 2;
        int k = n/3;
        if (n-k*3==1){ //剩余4
            k-=1;
        }
        int m = (n-k*3)/2;
        return (int) Math.pow(3,k)*(int) Math.pow(2,m);
    }
}
