package sort;

import java.util.Arrays;

public class SelectionSort {
    /**
     * 在未排序的序列中选择最小的元素放到起始位置，依次选择重复此过程
     * @param nums
     */
    public static void selectionSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }

            if (minIndex!=i) {
                int t = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = t;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {5,6,1,3,2,4,2};
        selectionSort(nums);
        System.out.print(Arrays.toString(nums));

    }
}