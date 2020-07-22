package sort;

import java.util.Arrays;

public class TopK快排 {


    public static void main(String[] args){
        int [] nums = {0,0,1,2,4,2,2,3,1,4};
        TopK快排 topK快排 = new TopK快排();
        System.out.println(Arrays.toString(topK快排.getLeastNumbers(nums,8)));
    }

    public int[] getLeastNumbers(int[] arr,int k ){
        if(k==0) return new int[0];
        if(k>=arr.length) return arr;

        quickSelect(arr,0,arr.length-1,k);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = arr[i];
        }

        return res;

    }

    private void quickSelect(int[] arr, int low, int height, int k) {
        int m = getIndex(arr, low, height);
        if(m==k) //m的索引为k前面刚好有k个数比它小
            return ;
        else if(m>k){ //m>k在左边找
            quickSelect(arr,low,m-1,k);
        }else{//在右边找k-m个数
            quickSelect(arr,m+1,height,k);//注意这里传入k
        }

    }

    public int getIndex(int[] arr,int low,int height){
        int temp = arr[low];
        while(low<height) {
            while (low < height && arr[height] >= temp) {
                height--;
            }
            arr[low] = arr[height];
            while (low < height && arr[low] <= temp) {
                low++;
            }
            arr[height] = arr[low];
        }

        arr[low] = temp;
        return low;
    }
}
