package sort;

import java.util.Arrays;

public class InsertSort {
    /**
     * 从第1个元素开始依次将元素插入前面有序的位置
     * @param args
     */
    public static void main(String[] args){
        int[] nums = {25,84,21,47,15,27,68,35,20};
        insertSort(nums);
        for(int k:nums)
            System.out.print(k+" ");
    }

    private static void insertSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int cur = nums[i];
            int j = i-1;
            for(;j>=0&&nums[j]>cur;j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = cur;
            System.out.println(Arrays.toString(nums));
        }

    }
}
