package dp.背包问题;

import java.util.Scanner;

public class 多重背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];

        for(int i=0;i<N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }



//        int[] dp = new int[V+1];
//        for(int i=0;i<N;i++){
//            for(int j=V;j>=v[i];j--){
//                for(int k=0;k<=s[i]&&k*v[i]<=j;k++){
//                    dp[j] = Math.max(dp[j],dp[j-k*v[i]]+k*w[i]);
//                }
//            }
//        }
//        System.out.println(dp[V]);
    }
}
