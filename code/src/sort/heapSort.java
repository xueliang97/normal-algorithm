package sort;

import java.util.Arrays;

public class heapSort {

    /**
     * 完全二叉树对应到数组，第i(从0开始)个节点的父节点 (i-1)/2,左孩子 2*i+1,右孩子2*i+2；第一个非叶子节点length/2-1
     * 升序用大根堆，降序用小根堆；从最后一个非叶节点开始调整
     * @param
     */
    public static void heapSort(int[] nums){
        for(int i=nums.length/2-1;i>=0;i--){   //第一次构建大顶堆,找到第一个非叶子节点，自底向上,自右往左
            buildHeap(nums,i,nums.length);
        }
        for(int i = nums.length-1;i>0;i--){ //进行nums,length-1次交换，交换完调整
            swap(nums,0,i);//交换尾和头
            buildHeap(nums,0,i);
        }
    }

    private static void buildHeap(int[] nums, int i, int length) {
        for(int k = 2*i+1;k<length;k=2*k+1){//找到该节点的左子节点，自顶向下依次调整，再找左子节点的左子节点
            if(k+1<length && nums[k+1]>nums[k]){ //当右子节点存在且大于左子节点，指向右子节点
                k++;
            }
            if(nums[i]>=nums[k]) //父节点大于等于子节点，调整完毕
                break;
            swap(nums,i,k);//交换节点
            i = k;//防止结构破环，指向调整后的节点，再向下调整堆
        }
    }

    public static void swap(int[] nums,int a,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args){
        int[] nums = {1,6,8,0,2,5,1};
        heapSort(nums);
        System.out.print(Arrays.toString(nums));
    }
}
