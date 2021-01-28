package com.yks.leetcode.剑指offer;

/**
 * @Description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @Author: Yu ki-r
 * @CreateDate: 2021/1/27 23:11
 */
public class Offer21 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 方法一：首位指针
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0 ,right = nums.length-1;
        while(left<right){
            if (nums[left]%2==1){
                left++;
            }else if (nums[right]%2==0){
                right--;
            }else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    /**
     * 方法二：快慢指针
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int slow =  0, fast = 0;
        while(fast<nums.length){
            if (nums[fast]%2==1){
                if (nums[slow]%2==0){
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
