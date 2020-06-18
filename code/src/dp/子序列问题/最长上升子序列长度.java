package dp.子序列问题;

import java.util.Arrays;

public class 最长上升子序列长度 {

    //子序列不要求连续，子数组要求连续
    public static void main(String[] args){
        int [] nums = {10,9,2,5,3,7,101,18};
        /**贪心+二分 保证上升的长度尽可能小才能最长
         * dp[i]表示长度为i+1上升子序列的最后一个元素
         * end dp[]数组结尾的索引
         */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int end = 0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[end]){//若nums[i]大于dp[]数组末尾元素，直接添加到末尾后
                dp[++end] = nums[i];
            }else{//否则找到dp 0~end中第一个大于nums[i]的位置，替换调
                int index = Arrays.binarySearch(dp,0,end+1,nums[i]);
                if(index<0)
                    dp[~index] = nums[i];
            }
        }
        System.out.println(++end);
        System.out.println(Arrays.toString(dp));
    }
}
