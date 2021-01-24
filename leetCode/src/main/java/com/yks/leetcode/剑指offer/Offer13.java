package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 13. 机器人的运动范围
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/24 14:25
 */
public class Offer13 {
    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     *
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     *
     */
    /**'
     * 前面提到搜索方向只需朝下或朝右，因此 (i, j) 的格子只会从 (i - 1, j) 或者 (i, j - 1) 两个格子走过来（不考虑边界条件），那么 vis[i][j] 是否可达的状态则可由如下公式计算得到：
     *
     *
     * 递推，board[i][j] = board[i-1][j] or board[i][j-1]
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {

        if (k==0){
            return 1;
        }
        boolean[][] board = new boolean[m][n];
        int count = 1;
        board[0][0] = true;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if ((i==0&&j==0)||get(i)+get(j)>k) continue;

                if (i-1>=0){
                    board[i][j] = board[i][j]||board[i-1][j];
                }
                if (j-1>=0){
                    board[i][j] =board[i][j]|| board[i][j-1];
                }
                count += board[i][j]?1:0;
            }
        }
        return count;
    }

    public int  get( int x) {
        int result = 0;
        while (x!=0){
            result +=x%10;
            x/=10;
        }
        return result;
    }


    /**
     * 方法二，深度优先算法
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {
        boolean[][] board = new boolean[m][n];
        return dfs(m,n,0,0,k,board);
    }

    public int dfs(int m, int n, int i,int j,int k,boolean[][] board){
        if (i>m||j>n||get(i)+get(j)>k||!board[i][j]) return 0;
        board[i][j] = true;
        return 1+dfs(m,n,i+1,j,k,board)+dfs(m,n,i,j+1,k,board);
    }

}
