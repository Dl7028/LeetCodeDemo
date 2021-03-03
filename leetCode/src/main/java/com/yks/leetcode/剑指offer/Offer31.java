package com.yks.leetcode.剑指offer;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 31. 栈的压入、弹出序列
 * @Author: Yu ki-r
 * @CreateDate: 2021/3/3 21:42
 */
public class Offer31 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * 示例 2：
     *
     * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * 输出：false
     * 解释：1 不能在 2 之前弹出。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 思路：借助辅助栈，若是下一个元素等于栈顶元素，直接出栈，若下一个元素不等于栈顶元素，把还未入栈的数字压入辅助栈，若全部数字已压入辅助栈，栈顶元素仍不等于下一个需要出栈的元素，返回false
     * 若出栈元素全部出栈，返回true
     * @param pushed 压栈顺序
     * @param popped 出栈顺序
     * @return 是否是出栈顺序
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed==null||popped==null) return false;
        boolean result  = false;
        int pNextPush = 0,pNextPop = 0;
        Stack<Integer> stack = new Stack<>();  //辅助栈
        while(popped.length-pNextPop>0){  //遍历出栈顺序
            while(stack.isEmpty()||stack.peek()!=popped[pNextPop]){ //遍历入栈顺序
                if (pushed.length-pNextPush == 0) break;  //若出栈顺序数组超出长度， break
                stack.push(pushed[pNextPush]); //压入辅助栈
                pNextPush++;  //指针像右移动
            }
            if (stack.peek()==popped[pNextPop]){
                stack.pop();
                pNextPop++;
            }else{  //若辅助栈栈顶元素不等于出栈顺序数组的元素，break；
                break;
            }
        }
        if (stack.isEmpty()&&popped.length-pNextPop== 0){  //遍历结束，辅助栈全部弹出，指针++后等于数组长度
            result = true;
        }
        return result;
    }
}
