package 高频;

import java.util.Arrays;
import java.util.Scanner;

public class 丑数2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] res = new int[n];
        int p2=0,p3=0,p5=0;
        res[0] = 1;
        for(int i=1;i<n;i++){
            res[i] = Math.min(Math.min(res[p2]*2,res[p3]*3),res[p5]*5);
            if(res[i]==res[p2]*2) p2++;
            if(res[i]==res[p3]*3) p3++;
            if(res[i]==res[p5]*5) p5++;
        }
        System.out.println(Arrays.toString(res));
    }
}
