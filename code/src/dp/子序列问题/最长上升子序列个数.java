package dp.子序列问题;

import java.util.Arrays;

public class 最长上升子序列个数 {


    public static void main(String[] args){
        int[] nums = {2,2,2,2,2};
        int dp[] = new int[nums.length]; //以nums[i]结尾的最长上升子序列的长度
        int cnt[] = new int[nums.length]; //以nums[i]结尾的最长上升子序列的个数
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        int max = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){ //第一次遇到以nums[i]结尾的最长上升子序列
                        dp[i] = Math.max(dp[j]+1,dp[i]);
                        cnt[i] = cnt[j];

                    }else if(dp[j]+1==dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }

        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==max)
                res += cnt[i];
        }
        System.out.println(res);

    }
}
