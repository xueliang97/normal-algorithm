package dp.背包问题;

import java.util.Scanner;

public class CompleteKnapsack {

    public static void main(String[] args){
        int N,V;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();
        int[] v = new int[N+1];
        int[] w = new int[N+1];
        for(int i=0;i<N;i++){
            v[i+1] = sc.nextInt();
            w[i+1] = sc.nextInt();
        }
        sc.close();
        int[] dp = new int[V+1]; //第i(1,...,N)个物品，质量恰好为j(1,...,V)的价值
        for(int i=1;i<=N;i++){
            for(int j=v[i];j<=V;j++){    //与0-1背包唯一不同的是这里正序遍历体积了
                dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]); //取和不取i个物品

            }
        }
        System.out.println(dp[V]);
    }
}
