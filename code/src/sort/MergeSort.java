package sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int l,int r,int[] nums){
        if(l==r)
            return new int[]{nums[l]};
        int mid = l+(r-l)/2;
        int[] leftArray = mergeSort(l,mid,nums); //注意是mid不是mid-1
        int[] rightArray = mergeSort(mid+1,r,nums);
        return merge(leftArray,rightArray);

    }

    public static int[] merge(int[] leftArray,int[] rightArray){
        int[] res = new int[leftArray.length+rightArray.length];
        int i=0,j=0,k=0;
        while(i<leftArray.length&&j<rightArray.length){
            res[k++] = leftArray[i]<rightArray[j]?leftArray[i++]:rightArray[j++];
        }
        if(i==leftArray.length){//右边直接合并
            while(j<rightArray.length){
                res[k++] = rightArray[j++];
            }
        }
        if(j==rightArray.length){//左边直接合并
            while(i<leftArray.length){
                res[k++] = leftArray[i++];
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums = {5,7,1,3,9,2,3,1};
        int[] newNum = mergeSort(0,nums.length-1,nums);
        for(int i:newNum)
            System.out.print(i+" ");
    }
}
