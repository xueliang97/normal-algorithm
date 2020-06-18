package dp.背包问题;

import java.util.Scanner;

/**
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 * 4 5
 * 1 2
 * 2 4
 * 3 4
 * 4 5
 */
public class Knapsack01 {

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
//        int[][] dp = new int[N+1][V+1]; //第i(1,...,N)个物品，质量恰好为j(1,...,V)的价值
//        for(int i=1;i<=N;i++){
//            for(int j=0;j<=V;j++){
//                if(v[i]<=j){
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]); //取和不取i个物品
//                }else
//                    dp[i][j] = dp[i-1][j];//当前物品重量大于当前体积只能不取
//            }
//        }
//        System.out.println(dp[N][V]);
        int[] dp = new int[V+1]; //第i(1,...,N)个物品，质量恰好为j(1,...,V)的价值
        for(int i=1;i<=N;i++){
            for(int j=V;j>=v[i];j--){
                    dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]); //取和不取i个物品

            }
        }
        System.out.println(dp[V]);


    }
}
