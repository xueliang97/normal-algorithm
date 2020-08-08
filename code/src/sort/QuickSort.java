package sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums,int low,int height){
        if(low>=height)
            return ;
        int i = getIndex(nums,low,height);//划分枢纽 取开头为枢纽从后往前，当height值<枢纽值
        // height值赋给low,从前往后;当low值>枢纽值 low赋给height值



        quickSort(nums,low,i-1);
        quickSort(nums,i+1,height);

    }

    public static void main(String[] args){
        int[] nums = {25,84,21,47,15,27,68,35,20};
        quickSort(nums,0,nums.length-1);
        for(int k:nums)
            System.out.print(k+" ");
    }
    public static int getIndex(int[] nums,int low,int height){//获得枢纽索引值
        int temp = nums[low]; //保存枢纽值
        while(low<height){
            while(low<height&&nums[height]>=temp){
                height--;
            }
            nums[low]  = nums[height];

            while(low<height&&nums[low]<=temp){
                low++;
            }
            nums[height] = nums[low];

        }

        nums[low] = temp;//返回时height = low;
        System.out.println(Arrays.toString(nums));
        return low;


    }
}
